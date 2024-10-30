/*    */ package ch.qos.logback.core.subst;
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
/*    */ public class Token
/*    */ {
/* 18 */   public static final Token START_TOKEN = new Token(Type.START, null);
/* 19 */   public static final Token CURLY_LEFT_TOKEN = new Token(Type.CURLY_LEFT, null);
/* 20 */   public static final Token CURLY_RIGHT_TOKEN = new Token(Type.CURLY_RIGHT, null); Type type;
/* 21 */   public static final Token DEFAULT_SEP_TOKEN = new Token(Type.DEFAULT, null);
/*    */   String payload;
/*    */   
/* 24 */   public enum Type { LITERAL, START, CURLY_LEFT, CURLY_RIGHT, DEFAULT; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Token(Type paramType, String paramString) {
/* 31 */     this.type = paramType;
/* 32 */     this.payload = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 37 */     if (this == paramObject)
/* 38 */       return true; 
/* 39 */     if (paramObject == null || getClass() != paramObject.getClass()) {
/* 40 */       return false;
/*    */     }
/* 42 */     Token token = (Token)paramObject;
/*    */     
/* 44 */     if (this.type != token.type)
/* 45 */       return false; 
/* 46 */     if ((this.payload != null) ? !this.payload.equals(token.payload) : (token.payload != null)) {
/* 47 */       return false;
/*    */     }
/* 49 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 54 */     int i = (this.type != null) ? this.type.hashCode() : 0;
/* 55 */     i = 31 * i + ((this.payload != null) ? this.payload.hashCode() : 0);
/* 56 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 61 */     String str = "Token{type=" + this.type;
/* 62 */     if (this.payload != null) {
/* 63 */       str = str + ", payload='" + this.payload + '\'';
/*    */     }
/* 65 */     str = str + '}';
/* 66 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\subst\Token.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */