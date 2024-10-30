/*     */ package javax.xml.stream.util;
/*     */ 
/*     */ import javax.xml.namespace.a;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.Location;
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StreamReaderDelegate
/*     */   implements XMLStreamReader
/*     */ {
/*     */   private XMLStreamReader reader;
/*     */   
/*     */   public StreamReaderDelegate() {}
/*     */   
/*     */   public StreamReaderDelegate(XMLStreamReader paramXMLStreamReader) {
/*  37 */     this.reader = paramXMLStreamReader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParent(XMLStreamReader paramXMLStreamReader) {
/*  45 */     this.reader = paramXMLStreamReader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLStreamReader getParent() {
/*  53 */     return this.reader;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int next() throws XMLStreamException {
/*  59 */     return this.reader.next();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int nextTag() throws XMLStreamException {
/*  65 */     return this.reader.nextTag();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getElementText() throws XMLStreamException {
/*  71 */     return this.reader.getElementText();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void require(int paramInt, String paramString1, String paramString2) throws XMLStreamException {
/*  77 */     this.reader.require(paramInt, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() throws XMLStreamException {
/*  83 */     return this.reader.hasNext();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws XMLStreamException {
/*  89 */     this.reader.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getNamespaceURI(String paramString) {
/*  94 */     return this.reader.getNamespaceURI(paramString);
/*     */   }
/*     */   
/*     */   public a getNamespaceContext() {
/*  98 */     return this.reader.getNamespaceContext();
/*     */   }
/*     */   
/*     */   public boolean isStartElement() {
/* 102 */     return this.reader.isStartElement();
/*     */   }
/*     */   
/*     */   public boolean isEndElement() {
/* 106 */     return this.reader.isEndElement();
/*     */   }
/*     */   
/*     */   public boolean isCharacters() {
/* 110 */     return this.reader.isCharacters();
/*     */   }
/*     */   
/*     */   public boolean isWhiteSpace() {
/* 114 */     return this.reader.isWhiteSpace();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAttributeValue(String paramString1, String paramString2) {
/* 120 */     return this.reader.getAttributeValue(paramString1, paramString2);
/*     */   }
/*     */   
/*     */   public int getAttributeCount() {
/* 124 */     return this.reader.getAttributeCount();
/*     */   }
/*     */   
/*     */   public b getAttributeName(int paramInt) {
/* 128 */     return this.reader.getAttributeName(paramInt);
/*     */   }
/*     */   
/*     */   public String getAttributePrefix(int paramInt) {
/* 132 */     return this.reader.getAttributePrefix(paramInt);
/*     */   }
/*     */   
/*     */   public String getAttributeNamespace(int paramInt) {
/* 136 */     return this.reader.getAttributeNamespace(paramInt);
/*     */   }
/*     */   
/*     */   public String getAttributeLocalName(int paramInt) {
/* 140 */     return this.reader.getAttributeLocalName(paramInt);
/*     */   }
/*     */   
/*     */   public String getAttributeType(int paramInt) {
/* 144 */     return this.reader.getAttributeType(paramInt);
/*     */   }
/*     */   
/*     */   public String getAttributeValue(int paramInt) {
/* 148 */     return this.reader.getAttributeValue(paramInt);
/*     */   }
/*     */   
/*     */   public boolean isAttributeSpecified(int paramInt) {
/* 152 */     return this.reader.isAttributeSpecified(paramInt);
/*     */   }
/*     */   
/*     */   public int getNamespaceCount() {
/* 156 */     return this.reader.getNamespaceCount();
/*     */   }
/*     */   
/*     */   public String getNamespacePrefix(int paramInt) {
/* 160 */     return this.reader.getNamespacePrefix(paramInt);
/*     */   }
/*     */   
/*     */   public String getNamespaceURI(int paramInt) {
/* 164 */     return this.reader.getNamespaceURI(paramInt);
/*     */   }
/*     */   
/*     */   public int getEventType() {
/* 168 */     return this.reader.getEventType();
/*     */   }
/*     */   
/*     */   public String getText() {
/* 172 */     return this.reader.getText();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTextCharacters(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) throws XMLStreamException {
/* 180 */     return this.reader.getTextCharacters(paramInt1, paramArrayOfchar, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char[] getTextCharacters() {
/* 188 */     return this.reader.getTextCharacters();
/*     */   }
/*     */   
/*     */   public int getTextStart() {
/* 192 */     return this.reader.getTextStart();
/*     */   }
/*     */   
/*     */   public int getTextLength() {
/* 196 */     return this.reader.getTextLength();
/*     */   }
/*     */   
/*     */   public String getEncoding() {
/* 200 */     return this.reader.getEncoding();
/*     */   }
/*     */   
/*     */   public boolean hasText() {
/* 204 */     return this.reader.hasText();
/*     */   }
/*     */   
/*     */   public Location getLocation() {
/* 208 */     return this.reader.getLocation();
/*     */   }
/*     */   
/*     */   public b getName() {
/* 212 */     return this.reader.getName();
/*     */   }
/*     */   
/*     */   public String getLocalName() {
/* 216 */     return this.reader.getLocalName();
/*     */   }
/*     */   
/*     */   public boolean hasName() {
/* 220 */     return this.reader.hasName();
/*     */   }
/*     */   
/*     */   public String getNamespaceURI() {
/* 224 */     return this.reader.getNamespaceURI();
/*     */   }
/*     */   
/*     */   public String getPrefix() {
/* 228 */     return this.reader.getPrefix();
/*     */   }
/*     */   
/*     */   public String getVersion() {
/* 232 */     return this.reader.getVersion();
/*     */   }
/*     */   
/*     */   public boolean isStandalone() {
/* 236 */     return this.reader.isStandalone();
/*     */   }
/*     */   
/*     */   public boolean standaloneSet() {
/* 240 */     return this.reader.standaloneSet();
/*     */   }
/*     */   
/*     */   public String getCharacterEncodingScheme() {
/* 244 */     return this.reader.getCharacterEncodingScheme();
/*     */   }
/*     */   
/*     */   public String getPITarget() {
/* 248 */     return this.reader.getPITarget();
/*     */   }
/*     */   
/*     */   public String getPIData() {
/* 252 */     return this.reader.getPIData();
/*     */   }
/*     */   
/*     */   public Object getProperty(String paramString) {
/* 256 */     return this.reader.getProperty(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\strea\\util\StreamReaderDelegate.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */