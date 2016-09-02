//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.09.02 a las 09:44:25 AM ECT 
//


package com.yaesta.integration.laarcourier.wsdl;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.yaesta.laarcourier.integration.wsdl package. 
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
public class ObjectFactory {

    private final static QName _WayBill_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "WayBill");
    private final static QName _AddressInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "AddressInfo");
    private final static QName _WayBillResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "WayBillResponse");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _CreateWayBillObjWayBillDetails_QNAME = new QName("http://tempuri.org/", "objWayBillDetails");
    private final static QName _CreateWayBillResponseCreateWayBillResult_QNAME = new QName("http://tempuri.org/", "CreateWayBillResult");
    private final static QName _AddressInfoAddressLine1_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "AddressLine1");
    private final static QName _AddressInfoAddressLine2_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "AddressLine2");
    private final static QName _AddressInfoCity_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "City");
    private final static QName _AddressInfoCountry_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "Country");
    private final static QName _AddressInfoName_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "Name");
    private final static QName _AddressInfoPhone_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "Phone");
    private final static QName _AddressInfoState_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "State");
    private final static QName _AddressInfoZipCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "ZipCode");
    private final static QName _WayBillResponseGUIANumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "GUIANumber");
    private final static QName _WayBillResponseMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "Message");
    private final static QName _WayBillBranch_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "Branch");
    private final static QName _WayBillComments_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "Comments");
    private final static QName _WayBillCompany_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "Company");
    private final static QName _WayBillContentSdtl_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "ContentSdtl");
    private final static QName _WayBillCustomerId_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "CustomerId");
    private final static QName _WayBillDeliveryAddress_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "DeliveryAddress");
    private final static QName _WayBillIdtrx_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "Idtrx");
    private final static QName _WayBillPassword_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "Password");
    private final static QName _WayBillPickUpConsignee_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "PickUpConsignee");
    private final static QName _WayBillPickupRequestDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "PickupRequestDate");
    private final static QName _WayBillService_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "Service");
    private final static QName _WayBillUnitDimension_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "UnitDimension");
    private final static QName _WayBillUsername_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "Username");
    private final static QName _WayBillWarehouseid_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "Warehouseid");
    private final static QName _WayBillWarehouseidloc_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "Warehouseidloc");
    private final static QName _WayBillWeightUnit_QNAME = new QName("http://schemas.datacontract.org/2004/07/WarehouseServices", "WeightUnit");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.yaesta.laarcourier.integration.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateWayBill }
     * 
     */
    public CreateWayBill createCreateWayBill() {
        return new CreateWayBill();
    }

    /**
     * Create an instance of {@link WayBill }
     * 
     */
    public WayBill createWayBill() {
        return new WayBill();
    }

    /**
     * Create an instance of {@link CreateWayBillResponse }
     * 
     */
    public CreateWayBillResponse createCreateWayBillResponse() {
        return new CreateWayBillResponse();
    }

    /**
     * Create an instance of {@link WayBillResponse }
     * 
     */
    public WayBillResponse createWayBillResponse() {
        return new WayBillResponse();
    }

    /**
     * Create an instance of {@link AddressInfo }
     * 
     */
    public AddressInfo createAddressInfo() {
        return new AddressInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WayBill }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "WayBill")
    public JAXBElement<WayBill> createWayBill(WayBill value) {
        return new JAXBElement<WayBill>(_WayBill_QNAME, WayBill.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "AddressInfo")
    public JAXBElement<AddressInfo> createAddressInfo(AddressInfo value) {
        return new JAXBElement<AddressInfo>(_AddressInfo_QNAME, AddressInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WayBillResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "WayBillResponse")
    public JAXBElement<WayBillResponse> createWayBillResponse(WayBillResponse value) {
        return new JAXBElement<WayBillResponse>(_WayBillResponse_QNAME, WayBillResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WayBill }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "objWayBillDetails", scope = CreateWayBill.class)
    public JAXBElement<WayBill> createCreateWayBillObjWayBillDetails(WayBill value) {
        return new JAXBElement<WayBill>(_CreateWayBillObjWayBillDetails_QNAME, WayBill.class, CreateWayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WayBillResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CreateWayBillResult", scope = CreateWayBillResponse.class)
    public JAXBElement<WayBillResponse> createCreateWayBillResponseCreateWayBillResult(WayBillResponse value) {
        return new JAXBElement<WayBillResponse>(_CreateWayBillResponseCreateWayBillResult_QNAME, WayBillResponse.class, CreateWayBillResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "AddressLine1", scope = AddressInfo.class)
    public JAXBElement<String> createAddressInfoAddressLine1(String value) {
        return new JAXBElement<String>(_AddressInfoAddressLine1_QNAME, String.class, AddressInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "AddressLine2", scope = AddressInfo.class)
    public JAXBElement<String> createAddressInfoAddressLine2(String value) {
        return new JAXBElement<String>(_AddressInfoAddressLine2_QNAME, String.class, AddressInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "City", scope = AddressInfo.class)
    public JAXBElement<String> createAddressInfoCity(String value) {
        return new JAXBElement<String>(_AddressInfoCity_QNAME, String.class, AddressInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "Country", scope = AddressInfo.class)
    public JAXBElement<String> createAddressInfoCountry(String value) {
        return new JAXBElement<String>(_AddressInfoCountry_QNAME, String.class, AddressInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "Name", scope = AddressInfo.class)
    public JAXBElement<String> createAddressInfoName(String value) {
        return new JAXBElement<String>(_AddressInfoName_QNAME, String.class, AddressInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "Phone", scope = AddressInfo.class)
    public JAXBElement<String> createAddressInfoPhone(String value) {
        return new JAXBElement<String>(_AddressInfoPhone_QNAME, String.class, AddressInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "State", scope = AddressInfo.class)
    public JAXBElement<String> createAddressInfoState(String value) {
        return new JAXBElement<String>(_AddressInfoState_QNAME, String.class, AddressInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "ZipCode", scope = AddressInfo.class)
    public JAXBElement<String> createAddressInfoZipCode(String value) {
        return new JAXBElement<String>(_AddressInfoZipCode_QNAME, String.class, AddressInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "GUIANumber", scope = WayBillResponse.class)
    public JAXBElement<String> createWayBillResponseGUIANumber(String value) {
        return new JAXBElement<String>(_WayBillResponseGUIANumber_QNAME, String.class, WayBillResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "Message", scope = WayBillResponse.class)
    public JAXBElement<String> createWayBillResponseMessage(String value) {
        return new JAXBElement<String>(_WayBillResponseMessage_QNAME, String.class, WayBillResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "Branch", scope = WayBill.class)
    public JAXBElement<String> createWayBillBranch(String value) {
        return new JAXBElement<String>(_WayBillBranch_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "Comments", scope = WayBill.class)
    public JAXBElement<String> createWayBillComments(String value) {
        return new JAXBElement<String>(_WayBillComments_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "Company", scope = WayBill.class)
    public JAXBElement<String> createWayBillCompany(String value) {
        return new JAXBElement<String>(_WayBillCompany_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "ContentSdtl", scope = WayBill.class)
    public JAXBElement<String> createWayBillContentSdtl(String value) {
        return new JAXBElement<String>(_WayBillContentSdtl_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "CustomerId", scope = WayBill.class)
    public JAXBElement<String> createWayBillCustomerId(String value) {
        return new JAXBElement<String>(_WayBillCustomerId_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "DeliveryAddress", scope = WayBill.class)
    public JAXBElement<AddressInfo> createWayBillDeliveryAddress(AddressInfo value) {
        return new JAXBElement<AddressInfo>(_WayBillDeliveryAddress_QNAME, AddressInfo.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "GUIANumber", scope = WayBill.class)
    public JAXBElement<String> createWayBillGUIANumber(String value) {
        return new JAXBElement<String>(_WayBillResponseGUIANumber_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "Idtrx", scope = WayBill.class)
    public JAXBElement<String> createWayBillIdtrx(String value) {
        return new JAXBElement<String>(_WayBillIdtrx_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "Password", scope = WayBill.class)
    public JAXBElement<String> createWayBillPassword(String value) {
        return new JAXBElement<String>(_WayBillPassword_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "PickUpConsignee", scope = WayBill.class)
    public JAXBElement<String> createWayBillPickUpConsignee(String value) {
        return new JAXBElement<String>(_WayBillPickUpConsignee_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "PickupRequestDate", scope = WayBill.class)
    public JAXBElement<String> createWayBillPickupRequestDate(String value) {
        return new JAXBElement<String>(_WayBillPickupRequestDate_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "Service", scope = WayBill.class)
    public JAXBElement<String> createWayBillService(String value) {
        return new JAXBElement<String>(_WayBillService_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "UnitDimension", scope = WayBill.class)
    public JAXBElement<String> createWayBillUnitDimension(String value) {
        return new JAXBElement<String>(_WayBillUnitDimension_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "Username", scope = WayBill.class)
    public JAXBElement<String> createWayBillUsername(String value) {
        return new JAXBElement<String>(_WayBillUsername_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "Warehouseid", scope = WayBill.class)
    public JAXBElement<String> createWayBillWarehouseid(String value) {
        return new JAXBElement<String>(_WayBillWarehouseid_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "Warehouseidloc", scope = WayBill.class)
    public JAXBElement<String> createWayBillWarehouseidloc(String value) {
        return new JAXBElement<String>(_WayBillWarehouseidloc_QNAME, String.class, WayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", name = "WeightUnit", scope = WayBill.class)
    public JAXBElement<String> createWayBillWeightUnit(String value) {
        return new JAXBElement<String>(_WayBillWeightUnit_QNAME, String.class, WayBill.class, value);
    }

}
