/*    */ package org.apache.xmlbeans;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StringEnumAbstractBase
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String _string;
/*    */   private int _int;
/*    */   
/*    */   protected StringEnumAbstractBase(String paramString, int paramInt) {
/* 46 */     this._string = paramString; this._int = paramInt;
/*    */   }
/*    */   
/*    */   public final String toString() {
/* 50 */     return this._string;
/*    */   }
/*    */   public final int intValue() {
/* 53 */     return this._int;
/*    */   }
/*    */   public final int hashCode() {
/* 56 */     return this._string.hashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Table
/*    */   {
/*    */     private Map _map;
/*    */     
/*    */     private List _list;
/*    */ 
/*    */     
/*    */     public Table(StringEnumAbstractBase[] param1ArrayOfStringEnumAbstractBase) {
/* 69 */       this._map = new HashMap(param1ArrayOfStringEnumAbstractBase.length);
/* 70 */       this._list = new ArrayList(param1ArrayOfStringEnumAbstractBase.length + 1);
/* 71 */       for (byte b = 0; b < param1ArrayOfStringEnumAbstractBase.length; b++) {
/*    */         
/* 73 */         this._map.put(param1ArrayOfStringEnumAbstractBase[b].toString(), param1ArrayOfStringEnumAbstractBase[b]);
/* 74 */         int i = param1ArrayOfStringEnumAbstractBase[b].intValue();
/* 75 */         while (this._list.size() <= i)
/* 76 */           this._list.add(null); 
/* 77 */         this._list.set(i, param1ArrayOfStringEnumAbstractBase[b]);
/*    */       } 
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public StringEnumAbstractBase forString(String param1String) {
/* 84 */       return (StringEnumAbstractBase)this._map.get(param1String);
/*    */     }
/*    */ 
/*    */     
/*    */     public StringEnumAbstractBase forInt(int param1Int) {
/* 89 */       if (param1Int < 0 || param1Int > this._list.size())
/* 90 */         return null; 
/* 91 */       return this._list.get(param1Int);
/*    */     }
/*    */ 
/*    */     
/*    */     public int lastInt() {
/* 96 */       return this._list.size() - 1;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\StringEnumAbstractBase.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */