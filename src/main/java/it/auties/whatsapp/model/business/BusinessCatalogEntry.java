package it.auties.whatsapp.model.business;

import java.net.URI;
import java.util.NoSuchElementException;

import it.auties.whatsapp.model.node.Node;

/**
 * A record class that represents a business catalog entry.
 *
 * @param id             the unique identifier of the catalog entry
 * @param encryptedImage the encrypted URL of the original image of the catalog entry
 * @param reviewStatus   the review status of the catalog entry
 * @param availability   the availability status of the catalog entry
 * @param name           the name of the catalog entry
 * @param sellerId       the unique identifier of the seller of the catalog entry
 * @param uri            the URI of the catalog entry
 * @param description    the description of the catalog entry
 * @param price          the price of the catalog entry
 * @param salePrice      the salePrice of the catalog entry
 * @param maxAvailable	 the maxAvailable qty of the catalog entry
 * @param currency       the currency of the price of the catalog entry
 * @param hidden         whether the catalog entry is hidden or not
 */
public record BusinessCatalogEntry(String id, URI encryptedImage, BusinessReviewStatus reviewStatus,
                                   BusinessItemAvailability availability, String name, String sellerId,
                                   URI uri, String description, long price, long salePrice, long maxAvailable, String currency,
                                   boolean hidden) {
    /**
     * A factory method that creates a BusinessCatalogEntry object from a given Node.
     *
     * @param node the node to get the data from
     * @return a BusinessCatalogEntry object
     * @throws NoSuchElementException if some required data is missing
     */
    public static BusinessCatalogEntry of(Node node) {
        var id = node.findChild("id")
                .flatMap(Node::contentAsString)
                .orElseThrow(() -> new NoSuchElementException("Missing id for catalog entry"));
        var hidden = node.attributes().getBoolean("is_hidden");
        var name = node.findChild("name")
                .flatMap(Node::contentAsString)
                .orElseThrow(() -> new NoSuchElementException("Missing name for catalog entry"));
        var encryptedImage = node.findChild("media")
                .flatMap(entry -> entry.findChild("image")).flatMap(entry -> entry.findChild("original_image_url"))
                .flatMap(Node::contentAsString)
                .map(URI::create)
                .orElseThrow(() -> new NoSuchElementException("Missing image for catalog entry"));
        var statusInfo = node.findChild("status_info")
                .flatMap(entry -> entry.findChild("status"))
                .flatMap(Node::contentAsString)
                .map(BusinessReviewStatus::of)
                .orElse(BusinessReviewStatus.NO_REVIEW);
        
        var availability = BusinessItemAvailability.of(node.attributes().getString("availability"));
        
        String sellerId = node.findChild("retailer_id")
                .flatMap(Node::contentAsString).orElse(name);
        
        var uri = node.findChild("url")
                .flatMap(Node::contentAsString)
                .map(URI::create)
                .orElse(null);
        
        var description = node.findChild("description").flatMap(Node::contentAsString).orElse("");
        
        var price = node.findChild("price")
                .flatMap(Node::contentAsString)
                .map(Long::parseUnsignedLong)
                .orElseThrow(() -> new NoSuchElementException("Missing price for catalog entry"));
        
        var salePrice = node.findChild("sale_price")
        		.flatMap(entry -> entry.findChild("price"))
                .flatMap(Node::contentAsString)
                .map(Long::parseUnsignedLong)
                .orElseThrow(() -> new NoSuchElementException("Missing sale_price for catalog entry"));
        
        var currency = node.findChild("currency")
                .flatMap(Node::contentAsString)
                .orElseThrow(() -> new NoSuchElementException("Missing currency for catalog entry"));
        
        var maxAvailable = node.findChild("max_available")
                .flatMap(Node::contentAsString)
                .map(Long::parseUnsignedLong)
                .orElseThrow(() -> new NoSuchElementException("Missing max_available for catalog entry"));

        return new BusinessCatalogEntry(id, encryptedImage, statusInfo, availability, name, sellerId, uri, description, price, salePrice, maxAvailable, currency, hidden);
    }
}
