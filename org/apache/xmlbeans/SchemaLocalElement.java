package org.apache.xmlbeans;

public interface SchemaLocalElement extends SchemaAnnotated, SchemaField {
  boolean blockExtension();
  
  boolean blockRestriction();
  
  boolean blockSubstitution();
  
  boolean isAbstract();
  
  SchemaIdentityConstraint[] getIdentityConstraints();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaLocalElement.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */