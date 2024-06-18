package in.jt.javaassist.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface  ProductMapper {

    @Mapping(source = "price", target = "formattedPrice")
    ProductDTO toDto(Product product);
}
