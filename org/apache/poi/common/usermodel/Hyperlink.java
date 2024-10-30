package org.apache.poi.common.usermodel;

import org.apache.poi.util.Removal;

public interface Hyperlink {
  @Removal(version = "3.17")
  public static final int LINK_URL = 1;
  
  @Removal(version = "3.17")
  public static final int LINK_DOCUMENT = 2;
  
  @Removal(version = "3.17")
  public static final int LINK_EMAIL = 3;
  
  @Removal(version = "3.17")
  public static final int LINK_FILE = 4;
  
  String getAddress();
  
  void setAddress(String paramString);
  
  String getLabel();
  
  void setLabel(String paramString);
  
  int getType();
  
  HyperlinkType getTypeEnum();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\commo\\usermodel\Hyperlink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */