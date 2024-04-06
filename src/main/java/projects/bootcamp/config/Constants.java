package projects.bootcamp.config;

public class Constants {
    public static final String NO_DATA_FOUND_EXCEPTION_MESSAGE = "No data was found in the database";
    public static final String ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE = "The element indicated does not exist";
    public static final String SUPPLIER_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The supplier you want to create already exists";
    public static final String PRODUCT_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The product you want to create already exists";
    public static final String EMPTY_FIELD_EXCEPTION_MESSAGE = "Field %s can not be empty";
    public static final String NEGATIVE_NOT_ALLOWED_EXCEPTION_MESSAGE = "Field %s can not receive negative values";
    public static final String SUPPLIER_NOT_FOUND_EXCEPTION_MESSAGE = "The supplier indicated for this product does not exist";
    public static final Long SOLD_OUT_VALUE = 0L;

    public static final String LIMIT_STRING_NAME_TECHNOLOGY = "technology can only have 50 characters";
    public static final String LIMIT_STRING_NAME_VERSION = "name can only have 50 characters";
    public static final String LIMIT_STRING_DESCRIPTION_TECHNOLOGY = "Description can only have 90 characters";

    private Constants(){
        throw new IllegalStateException("utility class");
    }
}
