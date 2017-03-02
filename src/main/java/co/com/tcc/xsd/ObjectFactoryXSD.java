
package co.com.tcc.xsd;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.tcc.xsd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactoryXSD {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.tcc.xsd
     * 
     */
    public ObjectFactoryXSD() {
    }

    /**
     * Create an instance of {@link TpDocumentoReferencia }
     * 
     */
    public TpDocumentoReferencia createTpDocumentoReferencia() {
        return new TpDocumentoReferencia();
    }

    /**
     * Create an instance of {@link TpGrabarRemesaCompleta }
     * 
     */
    public TpGrabarRemesaCompleta createTpGrabarRemesaCompleta() {
        return new TpGrabarRemesaCompleta();
    }

    /**
     * Create an instance of {@link TpUnidad }
     * 
     */
    public TpUnidad createTpUnidad() {
        return new TpUnidad();
    }

}
