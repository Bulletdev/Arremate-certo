package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.impl.common.PrefixResolver;

public interface NamespaceManager extends PrefixResolver {
  String find_prefix_for_nsuri(String paramString1, String paramString2);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\NamespaceManager.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */