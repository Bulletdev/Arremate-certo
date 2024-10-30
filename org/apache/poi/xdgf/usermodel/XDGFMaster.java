/*    */ package org.apache.poi.xdgf.usermodel;
/*    */ 
/*    */ import com.microsoft.schemas.office.visio.x2012.main.MasterType;
/*    */ import org.apache.poi.util.Internal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XDGFMaster
/*    */ {
/*    */   private MasterType _master;
/*    */   protected XDGFMasterContents _content;
/* 32 */   protected XDGFSheet _pageSheet = null;
/*    */ 
/*    */   
/*    */   public XDGFMaster(MasterType paramMasterType, XDGFMasterContents paramXDGFMasterContents, XDGFDocument paramXDGFDocument) {
/* 36 */     this._master = paramMasterType;
/* 37 */     this._content = paramXDGFMasterContents;
/* 38 */     paramXDGFMasterContents.setMaster(this);
/*    */     
/* 40 */     if (paramMasterType.isSetPageSheet())
/* 41 */       this._pageSheet = new XDGFPageSheet(paramMasterType.getPageSheet(), paramXDGFDocument); 
/*    */   }
/*    */   
/*    */   @Internal
/*    */   protected MasterType getXmlObject() {
/* 46 */     return this._master;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 51 */     return "<Master ID=\"" + getID() + "\" " + this._content + ">";
/*    */   }
/*    */   
/*    */   public long getID() {
/* 55 */     return this._master.getID();
/*    */   }
/*    */   
/*    */   public String getName() {
/* 59 */     return this._master.getName();
/*    */   }
/*    */   
/*    */   public XDGFMasterContents getContent() {
/* 63 */     return this._content;
/*    */   }
/*    */   
/*    */   public XDGFSheet getPageSheet() {
/* 67 */     return this._pageSheet;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFMaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */