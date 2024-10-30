package org.apache.xmlbeans.impl.values;

import javax.xml.namespace.b;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;

public interface TypeStoreUser {
  void attach_store(TypeStore paramTypeStore);
  
  SchemaType get_schema_type();
  
  TypeStore get_store();
  
  void invalidate_value();
  
  boolean uses_invalidate_value();
  
  String build_text(NamespaceManager paramNamespaceManager);
  
  boolean build_nil();
  
  void invalidate_nilvalue();
  
  void invalidate_element_order();
  
  void validate_now();
  
  void disconnect_store();
  
  TypeStoreUser create_element_user(b paramb1, b paramb2);
  
  TypeStoreUser create_attribute_user(b paramb);
  
  SchemaType get_element_type(b paramb1, b paramb2);
  
  SchemaType get_attribute_type(b paramb);
  
  String get_default_element_text(b paramb);
  
  String get_default_attribute_text(b paramb);
  
  int get_elementflags(b paramb);
  
  int get_attributeflags(b paramb);
  
  SchemaField get_attribute_field(b paramb);
  
  boolean is_child_element_order_sensitive();
  
  QNameSet get_element_ending_delimiters(b paramb);
  
  TypeStoreVisitor new_visitor();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\TypeStoreUser.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */