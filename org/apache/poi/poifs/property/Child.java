package org.apache.poi.poifs.property;

public interface Child {
  Child getNextChild();
  
  Child getPreviousChild();
  
  void setNextChild(Child paramChild);
  
  void setPreviousChild(Child paramChild);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\property\Child.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */