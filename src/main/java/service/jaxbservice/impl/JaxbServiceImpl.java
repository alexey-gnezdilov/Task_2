package service.jaxbservice.impl;

import dto.AbstractDTO;
import service.jaxbservice.JaxbService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JaxbServiceImpl implements JaxbService {
    @Override
    @SuppressWarnings({"unchecked"})
    public <K, T extends AbstractDTO<K>> List<K> unmarshalling(
            Class<T> dtoClass,
            Class<K> resultClass,
            String pathname)
            throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(dtoClass);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        T unmarshal = (T) jaxbUnmarshaller.unmarshal(new File(pathname));
        return unmarshal.getList();
    }
}