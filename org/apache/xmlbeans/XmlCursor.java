/*      */ package org.apache.xmlbeans;public interface XmlCursor extends XmlTokenSource { void dispose();
/*      */   boolean toCursor(XmlCursor paramXmlCursor);
/*      */   void push();
/*      */   boolean pop();
/*      */   void selectPath(String paramString);
/*      */   void selectPath(String paramString, XmlOptions paramXmlOptions);
/*      */   boolean hasNextSelection();
/*      */   boolean toNextSelection();
/*      */   boolean toSelection(int paramInt);
/*      */   int getSelectionCount();
/*      */   void addToSelection();
/*      */   void clearSelections();
/*      */   boolean toBookmark(XmlBookmark paramXmlBookmark);
/*      */   XmlBookmark toNextBookmark(Object paramObject);
/*      */   XmlBookmark toPrevBookmark(Object paramObject);
/*      */   b getName();
/*      */   void setName(b paramb);
/*      */   String namespaceForPrefix(String paramString);
/*      */   String prefixForNamespace(String paramString);
/*      */   void getAllNamespaces(Map paramMap);
/*      */   XmlObject getObject();
/*      */   TokenType currentTokenType();
/*      */   boolean isStartdoc();
/*      */   boolean isEnddoc();
/*      */   boolean isStart();
/*      */   boolean isEnd();
/*      */   boolean isText();
/*      */   boolean isAttr();
/*      */   boolean isNamespace();
/*      */   boolean isComment();
/*      */   boolean isProcinst();
/*      */   boolean isContainer();
/*      */   boolean isFinish();
/*      */   boolean isAnyAttr();
/*      */   TokenType prevTokenType();
/*      */   boolean hasNextToken();
/*      */   boolean hasPrevToken();
/*      */   TokenType toNextToken();
/*      */   TokenType toPrevToken();
/*      */   TokenType toFirstContentToken();
/*      */   TokenType toEndToken();
/*      */   int toNextChar(int paramInt);
/*      */   int toPrevChar(int paramInt);
/*      */   boolean toNextSibling();
/*      */   boolean toPrevSibling();
/*      */   boolean toParent();
/*      */   boolean toFirstChild();
/*      */   boolean toLastChild();
/*      */   boolean toChild(String paramString);
/*      */   boolean toChild(String paramString1, String paramString2);
/*      */   boolean toChild(b paramb);
/*      */   boolean toChild(int paramInt);
/*      */   boolean toChild(b paramb, int paramInt);
/*      */   boolean toNextSibling(String paramString);
/*      */   boolean toNextSibling(String paramString1, String paramString2);
/*      */   boolean toNextSibling(b paramb);
/*      */   boolean toFirstAttribute();
/*      */   boolean toLastAttribute();
/*      */   boolean toNextAttribute();
/*      */   boolean toPrevAttribute();
/*      */   String getAttributeText(b paramb);
/*      */   boolean setAttributeText(b paramb, String paramString);
/*      */   boolean removeAttribute(b paramb);
/*      */   String getTextValue();
/*      */   int getTextValue(char[] paramArrayOfchar, int paramInt1, int paramInt2);
/*      */   void setTextValue(String paramString);
/*      */   void setTextValue(char[] paramArrayOfchar, int paramInt1, int paramInt2);
/*      */   String getChars();
/*      */   int getChars(char[] paramArrayOfchar, int paramInt1, int paramInt2);
/*      */   void toStartDoc();
/*      */   void toEndDoc();
/*      */   boolean isInSameDocument(XmlCursor paramXmlCursor);
/*      */   int comparePosition(XmlCursor paramXmlCursor);
/*      */   boolean isLeftOf(XmlCursor paramXmlCursor);
/*      */   boolean isAtSamePositionAs(XmlCursor paramXmlCursor);
/*      */   boolean isRightOf(XmlCursor paramXmlCursor);
/*      */   XmlCursor execQuery(String paramString);
/*      */   XmlCursor execQuery(String paramString, XmlOptions paramXmlOptions);
/*      */   ChangeStamp getDocChangeStamp();
/*      */   void setBookmark(XmlBookmark paramXmlBookmark);
/*      */   XmlBookmark getBookmark(Object paramObject);
/*      */   void clearBookmark(Object paramObject);
/*      */   void getAllBookmarkRefs(Collection paramCollection);
/*      */   boolean removeXml();
/*      */   boolean moveXml(XmlCursor paramXmlCursor);
/*      */   boolean copyXml(XmlCursor paramXmlCursor);
/*      */   boolean removeXmlContents();
/*      */   boolean moveXmlContents(XmlCursor paramXmlCursor);
/*      */   boolean copyXmlContents(XmlCursor paramXmlCursor);
/*      */   int removeChars(int paramInt);
/*      */   int moveChars(int paramInt, XmlCursor paramXmlCursor);
/*      */   int copyChars(int paramInt, XmlCursor paramXmlCursor);
/*      */   void insertChars(String paramString);
/*      */   
/*      */   void insertElement(b paramb);
/*      */   
/*      */   void insertElement(String paramString);
/*      */   
/*      */   void insertElement(String paramString1, String paramString2);
/*      */   
/*      */   void beginElement(b paramb);
/*      */   
/*      */   void beginElement(String paramString);
/*      */   
/*      */   void beginElement(String paramString1, String paramString2);
/*      */   
/*      */   void insertElementWithText(b paramb, String paramString);
/*      */   
/*      */   void insertElementWithText(String paramString1, String paramString2);
/*      */   
/*      */   void insertElementWithText(String paramString1, String paramString2, String paramString3);
/*      */   
/*      */   void insertAttribute(String paramString);
/*      */   
/*      */   void insertAttribute(String paramString1, String paramString2);
/*      */   
/*      */   void insertAttribute(b paramb);
/*      */   
/*      */   void insertAttributeWithValue(String paramString1, String paramString2);
/*      */   
/*      */   void insertAttributeWithValue(String paramString1, String paramString2, String paramString3);
/*      */   
/*      */   void insertAttributeWithValue(b paramb, String paramString);
/*      */   
/*      */   void insertNamespace(String paramString1, String paramString2);
/*      */   
/*      */   void insertComment(String paramString);
/*      */   
/*      */   void insertProcInst(String paramString1, String paramString2);
/*      */   
/*      */   public static final class TokenType { public static final int INT_NONE = 0;
/*      */     public static final int INT_STARTDOC = 1;
/*      */     public static final int INT_ENDDOC = 2;
/*      */     public static final int INT_START = 3;
/*      */     public static final int INT_END = 4;
/*      */     
/*      */     public String toString() {
/*  138 */       return this._name;
/*      */     }
/*      */     public static final int INT_TEXT = 5; public static final int INT_ATTR = 6; public static final int INT_NAMESPACE = 7; public static final int INT_COMMENT = 8; public static final int INT_PROCINST = 9;
/*      */     
/*      */     public int intValue() {
/*  143 */       return this._value;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isNone() {
/*  167 */       return (this == NONE);
/*      */     } public boolean isStartdoc() {
/*  169 */       return (this == STARTDOC);
/*      */     } public boolean isEnddoc() {
/*  171 */       return (this == ENDDOC);
/*      */     } public boolean isStart() {
/*  173 */       return (this == START);
/*      */     } public boolean isEnd() {
/*  175 */       return (this == END);
/*      */     } public boolean isText() {
/*  177 */       return (this == TEXT);
/*      */     } public boolean isAttr() {
/*  179 */       return (this == ATTR);
/*      */     } public boolean isNamespace() {
/*  181 */       return (this == NAMESPACE);
/*      */     } public boolean isComment() {
/*  183 */       return (this == COMMENT);
/*      */     } public boolean isProcinst() {
/*  185 */       return (this == PROCINST);
/*      */     }
/*      */     public boolean isContainer() {
/*  188 */       return (this == STARTDOC || this == START);
/*      */     } public boolean isFinish() {
/*  190 */       return (this == ENDDOC || this == END);
/*      */     } public boolean isAnyAttr() {
/*  192 */       return (this == NAMESPACE || this == ATTR);
/*      */     }
/*      */     
/*  195 */     public static final TokenType NONE = new TokenType("NONE", 0);
/*      */     
/*  197 */     public static final TokenType STARTDOC = new TokenType("STARTDOC", 1);
/*      */     
/*  199 */     public static final TokenType ENDDOC = new TokenType("ENDDOC", 2);
/*      */     
/*  201 */     public static final TokenType START = new TokenType("START", 3);
/*      */     
/*  203 */     public static final TokenType END = new TokenType("END", 4);
/*      */     
/*  205 */     public static final TokenType TEXT = new TokenType("TEXT", 5);
/*      */     
/*  207 */     public static final TokenType ATTR = new TokenType("ATTR", 6);
/*      */     
/*  209 */     public static final TokenType NAMESPACE = new TokenType("NAMESPACE", 7);
/*      */     
/*  211 */     public static final TokenType COMMENT = new TokenType("COMMENT", 8);
/*      */     
/*  213 */     public static final TokenType PROCINST = new TokenType("PROCINST", 9); private String _name;
/*      */     private int _value;
/*      */     
/*      */     private TokenType(String param1String, int param1Int) {
/*  217 */       this._name = param1String;
/*  218 */       this._value = param1Int;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface ChangeStamp
/*      */   {
/*      */     boolean hasChanged();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static abstract class XmlBookmark
/*      */   {
/*      */     public XmlCursor.XmlMark _currentMark;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final Reference _ref;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public XmlBookmark() {
/* 1318 */       this(false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public XmlBookmark(boolean param1Boolean) {
/* 1326 */       this._ref = param1Boolean ? new WeakReference(this) : null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final XmlCursor createCursor() {
/* 1342 */       return (this._currentMark == null) ? null : this._currentMark.createCursor();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final XmlCursor toBookmark(XmlCursor param1XmlCursor) {
/* 1350 */       return (param1XmlCursor == null || !param1XmlCursor.toBookmark(this)) ? createCursor() : param1XmlCursor;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object getKey() {
/* 1362 */       return getClass();
/*      */     }
/*      */   }
/*      */   
/*      */   public static interface XmlMark {
/*      */     XmlCursor createCursor();
/*      */   } }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlCursor.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */