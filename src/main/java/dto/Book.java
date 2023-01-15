package dto;

import org.testng.TestException;
import pages.ProductPage;

public class Book {
    private String productTitle = "";
    private String author = "";
    private String offerPrice = "";
    private String edition = "";

    public Book() {
    }

    public Book(String productTitle, String author, String offerPrice, String edition) {
        this.productTitle = productTitle;
        this.author = author;
        this.offerPrice = offerPrice;
        this.edition = edition;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(String offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }



    @Override
    public String toString() {
        return "Book{" +
                "productTitle='" + productTitle + '\'' +
                ", author='" + author + '\'' +
                ", offerPrice='" + offerPrice + '\'' +
                ", edition='" + edition + '\'' +
                '}';
    }
}
