package org.h2.bnf;

import java.util.HashMap;

public interface Rule {
  void setLinks(HashMap<String, RuleHead> paramHashMap);
  
  boolean autoComplete(Sentence paramSentence);
  
  void accept(BnfVisitor paramBnfVisitor);
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\bnf\Rule.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */