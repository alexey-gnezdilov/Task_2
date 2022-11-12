package service.jaxbservice;

import dto.AbstractDTO;
import javax.xml.bind.JAXBException;
import java.util.List;

public interface JaxbService {
    <K, T extends AbstractDTO<K>> List<K> unmarshalling(
            Class<T> dtoClass,
            Class<K> resultClass,
            String pathname)
            throws JAXBException;
}