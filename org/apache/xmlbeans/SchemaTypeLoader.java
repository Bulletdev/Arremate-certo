package org.apache.xmlbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.namespace.b;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

public interface SchemaTypeLoader {
  SchemaType findType(b paramb);
  
  SchemaType findDocumentType(b paramb);
  
  SchemaType findAttributeType(b paramb);
  
  SchemaGlobalElement findElement(b paramb);
  
  SchemaGlobalAttribute findAttribute(b paramb);
  
  SchemaModelGroup findModelGroup(b paramb);
  
  SchemaAttributeGroup findAttributeGroup(b paramb);
  
  boolean isNamespaceDefined(String paramString);
  
  SchemaType.Ref findTypeRef(b paramb);
  
  SchemaType.Ref findDocumentTypeRef(b paramb);
  
  SchemaType.Ref findAttributeTypeRef(b paramb);
  
  SchemaGlobalElement.Ref findElementRef(b paramb);
  
  SchemaGlobalAttribute.Ref findAttributeRef(b paramb);
  
  SchemaModelGroup.Ref findModelGroupRef(b paramb);
  
  SchemaAttributeGroup.Ref findAttributeGroupRef(b paramb);
  
  SchemaIdentityConstraint.Ref findIdentityConstraintRef(b paramb);
  
  SchemaType typeForSignature(String paramString);
  
  SchemaType typeForClassname(String paramString);
  
  InputStream getSourceAsStream(String paramString);
  
  String compilePath(String paramString, XmlOptions paramXmlOptions) throws XmlException;
  
  String compileQuery(String paramString, XmlOptions paramXmlOptions) throws XmlException;
  
  XmlObject newInstance(SchemaType paramSchemaType, XmlOptions paramXmlOptions);
  
  XmlObject parse(String paramString, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException;
  
  XmlObject parse(File paramFile, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException;
  
  XmlObject parse(URL paramURL, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException;
  
  XmlObject parse(InputStream paramInputStream, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException;
  
  XmlObject parse(XMLStreamReader paramXMLStreamReader, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException;
  
  XmlObject parse(Reader paramReader, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException;
  
  XmlObject parse(Node paramNode, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException;
  
  XmlObject parse(XMLInputStream paramXMLInputStream, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, XMLStreamException;
  
  XmlSaxHandler newXmlSaxHandler(SchemaType paramSchemaType, XmlOptions paramXmlOptions);
  
  DOMImplementation newDomImplementation(XmlOptions paramXmlOptions);
  
  XMLInputStream newValidatingXMLInputStream(XMLInputStream paramXMLInputStream, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, XMLStreamException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaTypeLoader.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */