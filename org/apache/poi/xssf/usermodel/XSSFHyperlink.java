/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import org.apache.poi.common.usermodel.HyperlinkType;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.ss.usermodel.Hyperlink;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;
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
/*     */ public class XSSFHyperlink
/*     */   implements Hyperlink
/*     */ {
/*     */   private final HyperlinkType _type;
/*     */   private final PackageRelationship _externalRel;
/*     */   private final CTHyperlink _ctHyperlink;
/*     */   private String _location;
/*     */   
/*     */   protected XSSFHyperlink(int paramInt) {
/*  49 */     this(HyperlinkType.forInt(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFHyperlink(HyperlinkType paramHyperlinkType) {
/*  59 */     this._type = paramHyperlinkType;
/*  60 */     this._ctHyperlink = CTHyperlink.Factory.newInstance();
/*  61 */     this._externalRel = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFHyperlink(CTHyperlink paramCTHyperlink, PackageRelationship paramPackageRelationship) {
/*  71 */     this._ctHyperlink = paramCTHyperlink;
/*  72 */     this._externalRel = paramPackageRelationship;
/*     */ 
/*     */ 
/*     */     
/*  76 */     if (this._externalRel == null) {
/*     */       
/*  78 */       if (paramCTHyperlink.getLocation() != null)
/*  79 */       { this._type = HyperlinkType.DOCUMENT;
/*  80 */         this._location = paramCTHyperlink.getLocation(); }
/*  81 */       else { if (paramCTHyperlink.getId() != null) {
/*  82 */           throw new IllegalStateException("The hyperlink for cell " + paramCTHyperlink.getRef() + " references relation " + paramCTHyperlink.getId() + ", but that didn't exist!");
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*  87 */         this._type = HyperlinkType.DOCUMENT; }
/*     */     
/*     */     } else {
/*  90 */       URI uRI = this._externalRel.getTargetURI();
/*  91 */       this._location = uRI.toString();
/*  92 */       if (paramCTHyperlink.getLocation() != null)
/*     */       {
/*  94 */         this._location += "#" + paramCTHyperlink.getLocation();
/*     */       }
/*     */ 
/*     */       
/*  98 */       if (this._location.startsWith("http://") || this._location.startsWith("https://") || this._location.startsWith("ftp://")) {
/*     */         
/* 100 */         this._type = HyperlinkType.URL;
/* 101 */       } else if (this._location.startsWith("mailto:")) {
/* 102 */         this._type = HyperlinkType.EMAIL;
/*     */       } else {
/* 104 */         this._type = HyperlinkType.FILE;
/*     */       } 
/*     */     } 
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
/*     */   @Internal
/*     */   public XSSFHyperlink(Hyperlink paramHyperlink) {
/* 120 */     if (paramHyperlink instanceof XSSFHyperlink) {
/* 121 */       XSSFHyperlink xSSFHyperlink = (XSSFHyperlink)paramHyperlink;
/* 122 */       this._type = xSSFHyperlink.getTypeEnum();
/* 123 */       this._location = xSSFHyperlink._location;
/* 124 */       this._externalRel = xSSFHyperlink._externalRel;
/* 125 */       this._ctHyperlink = (CTHyperlink)xSSFHyperlink._ctHyperlink.copy();
/*     */     } else {
/*     */       
/* 128 */       this._type = paramHyperlink.getTypeEnum();
/* 129 */       this._location = paramHyperlink.getAddress();
/* 130 */       this._externalRel = null;
/* 131 */       this._ctHyperlink = CTHyperlink.Factory.newInstance();
/* 132 */       setCellReference(new CellReference(paramHyperlink.getFirstRow(), paramHyperlink.getFirstColumn()));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTHyperlink getCTHyperlink() {
/* 140 */     return this._ctHyperlink;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needsRelationToo() {
/* 148 */     return (this._type != HyperlinkType.DOCUMENT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generateRelationIfNeeded(PackagePart paramPackagePart) {
/* 155 */     if (this._externalRel == null && needsRelationToo()) {
/*     */       
/* 157 */       PackageRelationship packageRelationship = paramPackagePart.addExternalRelationship(this._location, XSSFRelation.SHEET_HYPERLINKS.getRelation());
/*     */ 
/*     */ 
/*     */       
/* 161 */       this._ctHyperlink.setId(packageRelationship.getId());
/*     */     } 
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
/*     */   public int getType() {
/* 175 */     return this._type.getCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HyperlinkType getTypeEnum() {
/* 185 */     return this._type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCellRef() {
/* 193 */     return this._ctHyperlink.getRef();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress() {
/* 204 */     return this._location;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLabel() {
/* 214 */     return this._ctHyperlink.getDisplay();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocation() {
/* 224 */     return this._ctHyperlink.getLocation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabel(String paramString) {
/* 234 */     this._ctHyperlink.setDisplay(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocation(String paramString) {
/* 244 */     this._ctHyperlink.setLocation(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress(String paramString) {
/* 255 */     validate(paramString);
/*     */     
/* 257 */     this._location = paramString;
/*     */     
/* 259 */     if (this._type == HyperlinkType.DOCUMENT) {
/* 260 */       setLocation(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void validate(String paramString) {
/* 266 */     switch (this._type) {
/*     */       
/*     */       case EMAIL:
/*     */       case FILE:
/*     */       case URL:
/*     */         try {
/* 272 */           new URI(paramString);
/* 273 */         } catch (URISyntaxException uRISyntaxException) {
/* 274 */           throw new IllegalArgumentException("Address of hyperlink must be a valid URI", uRISyntaxException);
/*     */         } 
/*     */       
/*     */       case DOCUMENT:
/*     */         return;
/*     */     } 
/*     */     
/* 281 */     throw new IllegalStateException("Invalid Hyperlink type: " + this._type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public void setCellReference(String paramString) {
/* 290 */     this._ctHyperlink.setRef(paramString);
/*     */   }
/*     */   @Internal
/*     */   protected void setCellReference(CellReference paramCellReference) {
/* 294 */     setCellReference(paramCellReference.formatAsString());
/*     */   }
/*     */   
/*     */   private CellReference buildCellReference() {
/* 298 */     String str = this._ctHyperlink.getRef();
/* 299 */     if (str == null) {
/* 300 */       str = "A1";
/*     */     }
/* 302 */     return new CellReference(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstColumn() {
/* 313 */     return buildCellReference().getCol();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastColumn() {
/* 324 */     return buildCellReference().getCol();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstRow() {
/* 334 */     return buildCellReference().getRow();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastRow() {
/* 345 */     return buildCellReference().getRow();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstColumn(int paramInt) {
/* 355 */     setCellReference(new CellReference(getFirstRow(), paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastColumn(int paramInt) {
/* 366 */     setFirstColumn(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstRow(int paramInt) {
/* 376 */     setCellReference(new CellReference(paramInt, getFirstColumn()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastRow(int paramInt) {
/* 387 */     setFirstRow(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTooltip() {
/* 394 */     return this._ctHyperlink.getTooltip();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTooltip(String paramString) {
/* 401 */     this._ctHyperlink.setTooltip(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFHyperlink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */