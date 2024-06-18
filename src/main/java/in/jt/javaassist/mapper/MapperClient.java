package in.jt.javaassist.mapper;

import in.jt.javaassist.mapstruct.Product;
import in.jt.javaassist.mapstruct.ProductDTO;
import in.jt.javaassist.mapstruct.ProductMapper;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

public class MapperClient {

    public static void main(String[] args) {
        Product product = new Product();
        product.setId(1L);
        product.setName("My Stuff");
        product.setDescription("Test product");
        product.setPrice(new BigDecimal("103500"));
        ProductMapper mapper = Mappers.getMapper(ProductMapper.class);
        ProductDTO productDTO = mapper.toDto(product);
        System.out.println(productDTO);
    }
}
