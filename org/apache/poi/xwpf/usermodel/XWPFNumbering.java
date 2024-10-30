/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument;
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
/*     */ public class XWPFNumbering
/*     */   extends POIXMLDocumentPart
/*     */ {
/*  46 */   protected List<XWPFAbstractNum> abstractNums = new ArrayList<XWPFAbstractNum>();
/*  47 */   protected List<XWPFNum> nums = new ArrayList<XWPFNum>();
/*     */ 
/*     */   
/*     */   boolean isNew;
/*     */ 
/*     */   
/*     */   private CTNumbering ctNumbering;
/*     */ 
/*     */   
/*     */   public XWPFNumbering(PackagePart paramPackagePart) throws IOException, OpenXML4JException {
/*  57 */     super(paramPackagePart);
/*  58 */     this.isNew = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XWPFNumbering(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, OpenXML4JException {
/*  66 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFNumbering() {
/*  73 */     this.abstractNums = new ArrayList<XWPFAbstractNum>();
/*  74 */     this.nums = new ArrayList<XWPFNum>();
/*  75 */     this.isNew = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onDocumentRead() throws IOException {
/*  83 */     NumberingDocument numberingDocument = null;
/*     */     
/*  85 */     InputStream inputStream = getPackagePart().getInputStream();
/*     */     try {
/*  87 */       numberingDocument = NumberingDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  88 */       this.ctNumbering = numberingDocument.getNumbering();
/*     */       
/*  90 */       for (CTNum cTNum : this.ctNumbering.getNumArray()) {
/*  91 */         this.nums.add(new XWPFNum(cTNum, this));
/*     */       }
/*  93 */       for (CTAbstractNum cTAbstractNum : this.ctNumbering.getAbstractNumArray()) {
/*  94 */         this.abstractNums.add(new XWPFAbstractNum(cTAbstractNum, this));
/*     */       }
/*  96 */       this.isNew = false;
/*  97 */     } catch (XmlException xmlException) {
/*  98 */       throw new POIXMLException();
/*     */     } finally {
/* 100 */       inputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 109 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 110 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTNumbering.type.getName().getNamespaceURI(), "numbering"));
/* 111 */     PackagePart packagePart = getPackagePart();
/* 112 */     OutputStream outputStream = packagePart.getOutputStream();
/* 113 */     this.ctNumbering.save(outputStream, xmlOptions);
/* 114 */     outputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNumbering(CTNumbering paramCTNumbering) {
/* 124 */     this.ctNumbering = paramCTNumbering;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean numExist(BigInteger paramBigInteger) {
/* 135 */     for (XWPFNum xWPFNum : this.nums) {
/* 136 */       if (xWPFNum.getCTNum().getNumId().equals(paramBigInteger))
/* 137 */         return true; 
/*     */     } 
/* 139 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigInteger addNum(XWPFNum paramXWPFNum) {
/* 148 */     this.ctNumbering.addNewNum();
/* 149 */     int i = this.ctNumbering.sizeOfNumArray() - 1;
/* 150 */     this.ctNumbering.setNumArray(i, paramXWPFNum.getCTNum());
/* 151 */     this.nums.add(paramXWPFNum);
/* 152 */     return paramXWPFNum.getCTNum().getNumId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigInteger addNum(BigInteger paramBigInteger) {
/* 161 */     CTNum cTNum = this.ctNumbering.addNewNum();
/* 162 */     cTNum.addNewAbstractNumId();
/* 163 */     cTNum.getAbstractNumId().setVal(paramBigInteger);
/* 164 */     cTNum.setNumId(BigInteger.valueOf((this.nums.size() + 1)));
/* 165 */     XWPFNum xWPFNum = new XWPFNum(cTNum, this);
/* 166 */     this.nums.add(xWPFNum);
/* 167 */     return cTNum.getNumId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addNum(BigInteger paramBigInteger1, BigInteger paramBigInteger2) {
/* 177 */     CTNum cTNum = this.ctNumbering.addNewNum();
/* 178 */     cTNum.addNewAbstractNumId();
/* 179 */     cTNum.getAbstractNumId().setVal(paramBigInteger1);
/* 180 */     cTNum.setNumId(paramBigInteger2);
/* 181 */     XWPFNum xWPFNum = new XWPFNum(cTNum, this);
/* 182 */     this.nums.add(xWPFNum);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFNum getNum(BigInteger paramBigInteger) {
/* 193 */     for (XWPFNum xWPFNum : this.nums) {
/* 194 */       if (xWPFNum.getCTNum().getNumId().equals(paramBigInteger))
/* 195 */         return xWPFNum; 
/*     */     } 
/* 197 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFAbstractNum getAbstractNum(BigInteger paramBigInteger) {
/* 208 */     for (XWPFAbstractNum xWPFAbstractNum : this.abstractNums) {
/* 209 */       if (xWPFAbstractNum.getAbstractNum().getAbstractNumId().equals(paramBigInteger)) {
/* 210 */         return xWPFAbstractNum;
/*     */       }
/*     */     } 
/* 213 */     return null;
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
/*     */   
/*     */   public BigInteger getIdOfAbstractNum(XWPFAbstractNum paramXWPFAbstractNum) {
/* 226 */     CTAbstractNum cTAbstractNum = (CTAbstractNum)paramXWPFAbstractNum.getCTAbstractNum().copy();
/* 227 */     XWPFAbstractNum xWPFAbstractNum = new XWPFAbstractNum(cTAbstractNum, this);
/*     */     
/* 229 */     for (byte b = 0; b < this.abstractNums.size(); b++) {
/* 230 */       xWPFAbstractNum.getCTAbstractNum().setAbstractNumId(BigInteger.valueOf(b));
/* 231 */       xWPFAbstractNum.setNumbering(this);
/* 232 */       if (xWPFAbstractNum.getCTAbstractNum().valueEquals((XmlObject)((XWPFAbstractNum)this.abstractNums.get(b)).getCTAbstractNum())) {
/* 233 */         return xWPFAbstractNum.getCTAbstractNum().getAbstractNumId();
/*     */       }
/*     */     } 
/* 236 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigInteger addAbstractNum(XWPFAbstractNum paramXWPFAbstractNum) {
/* 246 */     int i = this.abstractNums.size();
/* 247 */     if (paramXWPFAbstractNum.getAbstractNum() != null) {
/* 248 */       this.ctNumbering.addNewAbstractNum().set((XmlObject)paramXWPFAbstractNum.getAbstractNum());
/*     */     } else {
/* 250 */       this.ctNumbering.addNewAbstractNum();
/* 251 */       paramXWPFAbstractNum.getAbstractNum().setAbstractNumId(BigInteger.valueOf(i));
/* 252 */       this.ctNumbering.setAbstractNumArray(i, paramXWPFAbstractNum.getAbstractNum());
/*     */     } 
/* 254 */     this.abstractNums.add(paramXWPFAbstractNum);
/* 255 */     return paramXWPFAbstractNum.getCTAbstractNum().getAbstractNumId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAbstractNum(BigInteger paramBigInteger) {
/* 266 */     if (paramBigInteger.byteValue() < this.abstractNums.size()) {
/* 267 */       this.ctNumbering.removeAbstractNum(paramBigInteger.byteValue());
/* 268 */       this.abstractNums.remove(paramBigInteger.byteValue());
/* 269 */       return true;
/*     */     } 
/* 271 */     return false;
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
/*     */   public BigInteger getAbstractNumID(BigInteger paramBigInteger) {
/* 283 */     XWPFNum xWPFNum = getNum(paramBigInteger);
/* 284 */     if (xWPFNum == null)
/* 285 */       return null; 
/* 286 */     if (xWPFNum.getCTNum() == null)
/* 287 */       return null; 
/* 288 */     if (xWPFNum.getCTNum().getAbstractNumId() == null)
/* 289 */       return null; 
/* 290 */     return xWPFNum.getCTNum().getAbstractNumId().getVal();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFNumbering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */