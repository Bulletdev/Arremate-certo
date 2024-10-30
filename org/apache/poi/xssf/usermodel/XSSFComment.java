/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.office.excel.CTClientData;
/*     */ import com.microsoft.schemas.vml.CTShape;
/*     */ import java.math.BigInteger;
/*     */ import org.apache.poi.ss.usermodel.ClientAnchor;
/*     */ import org.apache.poi.ss.usermodel.Comment;
/*     */ import org.apache.poi.ss.usermodel.RichTextString;
/*     */ import org.apache.poi.ss.util.CellAddress;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.xssf.model.CommentsTable;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
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
/*     */ public class XSSFComment
/*     */   implements Comment
/*     */ {
/*     */   private final CTComment _comment;
/*     */   private final CommentsTable _comments;
/*     */   private final CTShape _vmlShape;
/*     */   private XSSFRichTextString _str;
/*     */   
/*     */   public XSSFComment(CommentsTable paramCommentsTable, CTComment paramCTComment, CTShape paramCTShape) {
/*  51 */     this._comment = paramCTComment;
/*  52 */     this._comments = paramCommentsTable;
/*  53 */     this._vmlShape = paramCTShape;
/*     */ 
/*     */ 
/*     */     
/*  57 */     if (paramCTShape != null && paramCTShape.sizeOfClientDataArray() > 0) {
/*  58 */       CellReference cellReference = new CellReference(paramCTComment.getRef());
/*  59 */       CTClientData cTClientData = paramCTShape.getClientDataArray(0);
/*  60 */       cTClientData.setRowArray(0, new BigInteger(String.valueOf(cellReference.getRow())));
/*  61 */       cTClientData.setColumnArray(0, new BigInteger(String.valueOf(cellReference.getCol())));
/*     */       
/*  63 */       avoidXmlbeansCorruptPointer(paramCTShape);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthor() {
/*  73 */     return this._comments.getAuthor((int)this._comment.getAuthorId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthor(String paramString) {
/*  83 */     this._comment.setAuthorId(this._comments.findAuthor(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumn() {
/*  93 */     return getAddress().getColumn();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRow() {
/* 101 */     return getAddress().getRow();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVisible() {
/* 109 */     boolean bool = false;
/* 110 */     if (this._vmlShape != null) {
/* 111 */       String str = this._vmlShape.getStyle();
/* 112 */       bool = (str != null && str.indexOf("visibility:visible") != -1) ? true : false;
/*     */     } 
/* 114 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 122 */     if (this._vmlShape != null) {
/*     */       String str;
/* 124 */       if (paramBoolean) { str = "position:absolute;visibility:visible"; }
/* 125 */       else { str = "position:absolute;visibility:hidden"; }
/* 126 */        this._vmlShape.setStyle(str);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CellAddress getAddress() {
/* 132 */     return new CellAddress(this._comment.getRef());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAddress(int paramInt1, int paramInt2) {
/* 137 */     setAddress(new CellAddress(paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAddress(CellAddress paramCellAddress) {
/* 142 */     CellAddress cellAddress = new CellAddress(this._comment.getRef());
/* 143 */     if (paramCellAddress.equals(cellAddress)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 148 */     this._comment.setRef(paramCellAddress.formatAsString());
/* 149 */     this._comments.referenceUpdated(cellAddress, this._comment);
/*     */     
/* 151 */     if (this._vmlShape != null) {
/* 152 */       CTClientData cTClientData = this._vmlShape.getClientDataArray(0);
/* 153 */       cTClientData.setRowArray(0, new BigInteger(String.valueOf(paramCellAddress.getRow())));
/* 154 */       cTClientData.setColumnArray(0, new BigInteger(String.valueOf(paramCellAddress.getColumn())));
/*     */       
/* 156 */       avoidXmlbeansCorruptPointer(this._vmlShape);
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
/*     */   public void setColumn(int paramInt) {
/* 169 */     setAddress(getRow(), paramInt);
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
/*     */   public void setRow(int paramInt) {
/* 181 */     setAddress(paramInt, getColumn());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFRichTextString getString() {
/* 189 */     if (this._str == null) {
/* 190 */       CTRst cTRst = this._comment.getText();
/* 191 */       if (cTRst != null) this._str = new XSSFRichTextString(this._comment.getText()); 
/*     */     } 
/* 193 */     return this._str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setString(RichTextString paramRichTextString) {
/* 203 */     if (!(paramRichTextString instanceof XSSFRichTextString)) {
/* 204 */       throw new IllegalArgumentException("Only XSSFRichTextString argument is supported");
/*     */     }
/* 206 */     this._str = (XSSFRichTextString)paramRichTextString;
/* 207 */     this._comment.setText(this._str.getCTRst());
/*     */   }
/*     */   
/*     */   public void setString(String paramString) {
/* 211 */     setString(new XSSFRichTextString(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public ClientAnchor getClientAnchor() {
/* 216 */     String str = this._vmlShape.getClientDataArray(0).getAnchorArray(0);
/* 217 */     int[] arrayOfInt = new int[8];
/* 218 */     byte b = 0;
/* 219 */     for (String str1 : str.split(",")) {
/* 220 */       arrayOfInt[b++] = Integer.parseInt(str1.trim());
/*     */     }
/* 222 */     return new XSSFClientAnchor(arrayOfInt[1] * 9525, arrayOfInt[3] * 9525, arrayOfInt[5] * 9525, arrayOfInt[7] * 9525, arrayOfInt[0], arrayOfInt[2], arrayOfInt[4], arrayOfInt[6]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CTComment getCTComment() {
/* 230 */     return this._comment;
/*     */   }
/*     */   
/*     */   protected CTShape getCTShape() {
/* 234 */     return this._vmlShape;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 239 */     if (!(paramObject instanceof XSSFComment)) {
/* 240 */       return false;
/*     */     }
/* 242 */     XSSFComment xSSFComment = (XSSFComment)paramObject;
/* 243 */     return (getCTComment() == xSSFComment.getCTComment() && getCTShape() == xSSFComment.getCTShape());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 249 */     return (getRow() * 17 + getColumn()) * 31;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void avoidXmlbeansCorruptPointer(CTShape paramCTShape) {
/* 256 */     paramCTShape.getClientDataList().toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFComment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */