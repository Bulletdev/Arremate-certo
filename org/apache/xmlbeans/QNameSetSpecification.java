package org.apache.xmlbeans;

import java.util.Set;
import javax.xml.namespace.b;

public interface QNameSetSpecification {
  boolean contains(b paramb);
  
  boolean isAll();
  
  boolean isEmpty();
  
  boolean containsAll(QNameSetSpecification paramQNameSetSpecification);
  
  boolean isDisjoint(QNameSetSpecification paramQNameSetSpecification);
  
  QNameSet intersect(QNameSetSpecification paramQNameSetSpecification);
  
  QNameSet union(QNameSetSpecification paramQNameSetSpecification);
  
  QNameSet inverse();
  
  Set excludedURIs();
  
  Set includedURIs();
  
  Set excludedQNamesInIncludedURIs();
  
  Set includedQNamesInExcludedURIs();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\QNameSetSpecification.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */