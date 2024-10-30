/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.office.excel.CTClientData;
/*     */ import com.microsoft.schemas.office.excel.STObjectType;
/*     */ import com.microsoft.schemas.office.office.CTIdMap;
/*     */ import com.microsoft.schemas.office.office.CTShapeLayout;
/*     */ import com.microsoft.schemas.office.office.STConnectType;
/*     */ import com.microsoft.schemas.office.office.STInsetMode;
/*     */ import com.microsoft.schemas.vml.CTPath;
/*     */ import com.microsoft.schemas.vml.CTShadow;
/*     */ import com.microsoft.schemas.vml.CTShape;
/*     */ import com.microsoft.schemas.vml.CTShapetype;
/*     */ import com.microsoft.schemas.vml.STExt;
/*     */ import com.microsoft.schemas.vml.STStrokeJoinStyle;
/*     */ import com.microsoft.schemas.vml.STTrueFalse;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.StringReader;
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.util.DocumentHelper;
/*     */ import org.apache.poi.xssf.util.EvilUnclosedBRFixingInputStream;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
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
/*     */ 
/*     */ 
/*     */ public final class XSSFVMLDrawing
/*     */   extends POIXMLDocumentPart
/*     */ {
/*  86 */   private static final b QNAME_SHAPE_LAYOUT = new b("urn:schemas-microsoft-com:office:office", "shapelayout");
/*  87 */   private static final b QNAME_SHAPE_TYPE = new b("urn:schemas-microsoft-com:vml", "shapetype");
/*  88 */   private static final b QNAME_SHAPE = new b("urn:schemas-microsoft-com:vml", "shape");
/*     */ 
/*     */   
/*     */   private static final String COMMENT_SHAPE_TYPE_ID = "_x0000_t202";
/*     */ 
/*     */   
/*  94 */   private static final Pattern ptrn_shapeId = Pattern.compile("_x0000_s(\\d+)");
/*     */   
/*  96 */   private List<b> _qnames = new ArrayList<b>();
/*  97 */   private List<XmlObject> _items = new ArrayList<XmlObject>();
/*     */   private String _shapeTypeId;
/*  99 */   private int _shapeId = 1024;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFVMLDrawing() {
/* 108 */     newDrawing();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFVMLDrawing(PackagePart paramPackagePart) throws IOException, XmlException {
/* 120 */     super(paramPackagePart);
/* 121 */     read(getPackagePart().getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected XSSFVMLDrawing(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, XmlException {
/* 129 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void read(InputStream paramInputStream) throws IOException, XmlException {
/*     */     Document document;
/*     */     try {
/* 136 */       document = DocumentHelper.readDocument((InputStream)new EvilUnclosedBRFixingInputStream(paramInputStream));
/* 137 */     } catch (SAXException sAXException) {
/* 138 */       throw new XmlException(sAXException.getMessage(), sAXException);
/*     */     } 
/* 140 */     XmlObject xmlObject = XmlObject.Factory.parse(document, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */     
/* 142 */     this._qnames = new ArrayList<b>();
/* 143 */     this._items = new ArrayList<XmlObject>();
/* 144 */     for (XmlObject xmlObject1 : xmlObject.selectPath("$this/xml/*")) {
/* 145 */       Node node = xmlObject1.getDomNode();
/* 146 */       b b1 = new b(node.getNamespaceURI(), node.getLocalName());
/* 147 */       if (b1.equals(QNAME_SHAPE_LAYOUT)) {
/* 148 */         this._items.add(CTShapeLayout.Factory.parse(xmlObject1.xmlText(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
/* 149 */       } else if (b1.equals(QNAME_SHAPE_TYPE)) {
/* 150 */         CTShapetype cTShapetype = CTShapetype.Factory.parse(xmlObject1.xmlText(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 151 */         this._items.add(cTShapetype);
/* 152 */         this._shapeTypeId = cTShapetype.getId();
/* 153 */       } else if (b1.equals(QNAME_SHAPE)) {
/* 154 */         CTShape cTShape = CTShape.Factory.parse(xmlObject1.xmlText(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 155 */         String str = cTShape.getId();
/* 156 */         if (str != null) {
/* 157 */           Matcher matcher = ptrn_shapeId.matcher(str);
/* 158 */           if (matcher.find()) this._shapeId = Math.max(this._shapeId, Integer.parseInt(matcher.group(1))); 
/*     */         } 
/* 160 */         this._items.add(cTShape);
/*     */       } else {
/*     */         Document document1;
/*     */         try {
/* 164 */           InputSource inputSource = new InputSource(new StringReader(xmlObject1.xmlText()));
/* 165 */           document1 = DocumentHelper.readDocument(inputSource);
/* 166 */         } catch (SAXException sAXException) {
/* 167 */           throw new XmlException(sAXException.getMessage(), sAXException);
/*     */         } 
/*     */         
/* 170 */         this._items.add(XmlObject.Factory.parse(document1, POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
/*     */       } 
/* 172 */       this._qnames.add(b1);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected List<XmlObject> getItems() {
/* 177 */     return this._items;
/*     */   }
/*     */   
/*     */   protected void write(OutputStream paramOutputStream) throws IOException {
/* 181 */     XmlObject xmlObject = XmlObject.Factory.newInstance();
/* 182 */     XmlCursor xmlCursor = xmlObject.newCursor();
/* 183 */     xmlCursor.toNextToken();
/* 184 */     xmlCursor.beginElement("xml");
/*     */     
/* 186 */     for (byte b1 = 0; b1 < this._items.size(); b1++) {
/* 187 */       XmlCursor xmlCursor1 = ((XmlObject)this._items.get(b1)).newCursor();
/* 188 */       xmlCursor.beginElement(this._qnames.get(b1));
/* 189 */       while (xmlCursor1.toNextToken() == XmlCursor.TokenType.ATTR) {
/* 190 */         Node node = xmlCursor1.getDomNode();
/* 191 */         xmlCursor.insertAttributeWithValue(node.getLocalName(), node.getNamespaceURI(), node.getNodeValue());
/*     */       } 
/* 193 */       xmlCursor1.toStartDoc();
/* 194 */       xmlCursor1.copyXmlContents(xmlCursor);
/* 195 */       xmlCursor.toNextToken();
/* 196 */       xmlCursor1.dispose();
/*     */     } 
/* 198 */     xmlCursor.dispose();
/*     */     
/* 200 */     xmlObject.save(paramOutputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 205 */     PackagePart packagePart = getPackagePart();
/* 206 */     OutputStream outputStream = packagePart.getOutputStream();
/* 207 */     write(outputStream);
/* 208 */     outputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void newDrawing() {
/* 215 */     CTShapeLayout cTShapeLayout = CTShapeLayout.Factory.newInstance();
/* 216 */     cTShapeLayout.setExt(STExt.EDIT);
/* 217 */     CTIdMap cTIdMap = cTShapeLayout.addNewIdmap();
/* 218 */     cTIdMap.setExt(STExt.EDIT);
/* 219 */     cTIdMap.setData("1");
/* 220 */     this._items.add(cTShapeLayout);
/* 221 */     this._qnames.add(QNAME_SHAPE_LAYOUT);
/*     */     
/* 223 */     CTShapetype cTShapetype = CTShapetype.Factory.newInstance();
/* 224 */     this._shapeTypeId = "_x0000_t202";
/* 225 */     cTShapetype.setId(this._shapeTypeId);
/* 226 */     cTShapetype.setCoordsize("21600,21600");
/* 227 */     cTShapetype.setSpt(202.0F);
/* 228 */     cTShapetype.setPath2("m,l,21600r21600,l21600,xe");
/* 229 */     cTShapetype.addNewStroke().setJoinstyle(STStrokeJoinStyle.MITER);
/* 230 */     CTPath cTPath = cTShapetype.addNewPath();
/* 231 */     cTPath.setGradientshapeok(STTrueFalse.T);
/* 232 */     cTPath.setConnecttype(STConnectType.RECT);
/* 233 */     this._items.add(cTShapetype);
/* 234 */     this._qnames.add(QNAME_SHAPE_TYPE);
/*     */   }
/*     */   
/*     */   protected CTShape newCommentShape() {
/* 238 */     CTShape cTShape = CTShape.Factory.newInstance();
/* 239 */     cTShape.setId("_x0000_s" + ++this._shapeId);
/* 240 */     cTShape.setType("#" + this._shapeTypeId);
/* 241 */     cTShape.setStyle("position:absolute; visibility:hidden");
/* 242 */     cTShape.setFillcolor("#ffffe1");
/* 243 */     cTShape.setInsetmode(STInsetMode.AUTO);
/* 244 */     cTShape.addNewFill().setColor("#ffffe1");
/* 245 */     CTShadow cTShadow = cTShape.addNewShadow();
/* 246 */     cTShadow.setOn(STTrueFalse.T);
/* 247 */     cTShadow.setColor("black");
/* 248 */     cTShadow.setObscured(STTrueFalse.T);
/* 249 */     cTShape.addNewPath().setConnecttype(STConnectType.NONE);
/* 250 */     cTShape.addNewTextbox().setStyle("mso-direction-alt:auto");
/* 251 */     CTClientData cTClientData = cTShape.addNewClientData();
/* 252 */     cTClientData.setObjectType(STObjectType.NOTE);
/* 253 */     cTClientData.addNewMoveWithCells();
/* 254 */     cTClientData.addNewSizeWithCells();
/* 255 */     cTClientData.addNewAnchor().setStringValue("1, 15, 0, 2, 3, 15, 3, 16");
/* 256 */     cTClientData.addNewAutoFill().setStringValue("False");
/* 257 */     cTClientData.addNewRow().setBigIntegerValue(new BigInteger("0"));
/* 258 */     cTClientData.addNewColumn().setBigIntegerValue(new BigInteger("0"));
/* 259 */     this._items.add(cTShape);
/* 260 */     this._qnames.add(QNAME_SHAPE);
/* 261 */     return cTShape;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CTShape findCommentShape(int paramInt1, int paramInt2) {
/* 270 */     for (XmlObject xmlObject : this._items) {
/* 271 */       if (xmlObject instanceof CTShape) {
/* 272 */         CTShape cTShape = (CTShape)xmlObject;
/* 273 */         if (cTShape.sizeOfClientDataArray() > 0) {
/* 274 */           CTClientData cTClientData = cTShape.getClientDataArray(0);
/* 275 */           if (cTClientData.getObjectType() == STObjectType.NOTE) {
/* 276 */             int i = cTClientData.getRowArray(0).intValue();
/* 277 */             int j = cTClientData.getColumnArray(0).intValue();
/* 278 */             if (i == paramInt1 && j == paramInt2) {
/* 279 */               return cTShape;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 285 */     return null;
/*     */   }
/*     */   
/*     */   protected boolean removeCommentShape(int paramInt1, int paramInt2) {
/* 289 */     CTShape cTShape = findCommentShape(paramInt1, paramInt2);
/* 290 */     return (cTShape != null && this._items.remove(cTShape));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFVMLDrawing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */