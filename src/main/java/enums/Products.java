package enums;

public enum Products {
    HITCHHIKERS_GUIDE("0345391802", "The Hitchhiker's Guide to the Galaxy");

    private String id;
    private String productTitle;

    Products() {
    }

    Products(String id, String productTitle) {
        this.id = id;
        this.productTitle = productTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }
}
