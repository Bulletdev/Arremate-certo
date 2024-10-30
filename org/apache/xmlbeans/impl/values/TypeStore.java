package org.apache.xmlbeans.impl.values;

import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlLocale;

public interface TypeStore extends NamespaceManager {
  public static final int WS_UNSPECIFIED = 0;
  
  public static final int WS_PRESERVE = 1;
  
  public static final int WS_REPLACE = 2;
  
  public static final int WS_COLLAPSE = 3;
  
  public static final int NILLABLE = 1;
  
  public static final int HASDEFAULT = 2;
  
  public static final int FIXED = 4;
  
  XmlCursor new_cursor();
  
  void validate(ValidatorListener paramValidatorListener);
  
  SchemaTypeLoader get_schematypeloader();
  
  TypeStoreUser change_type(SchemaType paramSchemaType);
  
  TypeStoreUser substitute(b paramb, SchemaType paramSchemaType);
  
  boolean is_attribute();
  
  b get_xsi_type();
  
  void invalidate_text();
  
  String fetch_text(int paramInt);
  
  void store_text(String paramString);
  
  String compute_default_text();
  
  int compute_flags();
  
  boolean validate_on_set();
  
  SchemaField get_schema_field();
  
  void invalidate_nil();
  
  boolean find_nil();
  
  int count_elements(b paramb);
  
  int count_elements(QNameSet paramQNameSet);
  
  TypeStoreUser find_element_user(b paramb, int paramInt);
  
  TypeStoreUser find_element_user(QNameSet paramQNameSet, int paramInt);
  
  void find_all_element_users(b paramb, List paramList);
  
  void find_all_element_users(QNameSet paramQNameSet, List paramList);
  
  TypeStoreUser insert_element_user(b paramb, int paramInt);
  
  TypeStoreUser insert_element_user(QNameSet paramQNameSet, b paramb, int paramInt);
  
  TypeStoreUser add_element_user(b paramb);
  
  void remove_element(b paramb, int paramInt);
  
  void remove_element(QNameSet paramQNameSet, int paramInt);
  
  TypeStoreUser find_attribute_user(b paramb);
  
  TypeStoreUser add_attribute_user(b paramb);
  
  void remove_attribute(b paramb);
  
  TypeStoreUser copy_contents_from(TypeStore paramTypeStore);
  
  TypeStoreUser copy(SchemaTypeLoader paramSchemaTypeLoader, SchemaType paramSchemaType, XmlOptions paramXmlOptions);
  
  void array_setter(XmlObject[] paramArrayOfXmlObject, b paramb);
  
  void visit_elements(TypeStoreVisitor paramTypeStoreVisitor);
  
  XmlObject[] exec_query(String paramString, XmlOptions paramXmlOptions) throws XmlException;
  
  Object get_root_object();
  
  XmlLocale get_locale();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\TypeStore.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */