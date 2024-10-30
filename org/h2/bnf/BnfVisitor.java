package org.h2.bnf;

import java.util.ArrayList;

public interface BnfVisitor {
  void visitRuleElement(boolean paramBoolean, String paramString, Rule paramRule);
  
  void visitRuleRepeat(boolean paramBoolean, Rule paramRule);
  
  void visitRuleFixed(int paramInt);
  
  void visitRuleList(boolean paramBoolean, ArrayList<Rule> paramArrayList);
  
  void visitRuleOptional(Rule paramRule);
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\bnf\BnfVisitor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */