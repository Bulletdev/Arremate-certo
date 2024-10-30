/*    */ package ch.qos.logback.core.pattern.parser;
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
/*    */ public class Node
/*    */ {
/*    */   static final int LITERAL = 0;
/*    */   static final int SIMPLE_KEYWORD = 1;
/*    */   static final int COMPOSITE_KEYWORD = 2;
/*    */   final int type;
/*    */   final Object value;
/*    */   Node next;
/*    */   
/*    */   Node(int paramInt) {
/* 26 */     this(paramInt, null);
/*    */   }
/*    */   
/*    */   Node(int paramInt, Object paramObject) {
/* 30 */     this.type = paramInt;
/* 31 */     this.value = paramObject;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getType() {
/* 38 */     return this.type;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getValue() {
/* 45 */     return this.value;
/*    */   }
/*    */   
/*    */   public Node getNext() {
/* 49 */     return this.next;
/*    */   }
/*    */   
/*    */   public void setNext(Node paramNode) {
/* 53 */     this.next = paramNode;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 57 */     if (this == paramObject) {
/* 58 */       return true;
/*    */     }
/* 60 */     if (!(paramObject instanceof Node)) {
/* 61 */       return false;
/*    */     }
/* 63 */     Node node = (Node)paramObject;
/*    */     
/* 65 */     return (this.type == node.type && ((this.value != null) ? this.value.equals(node.value) : (node.value == null)) && ((this.next != null) ? this.next.equals(node.next) : (node.next == null)));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 70 */     int i = this.type;
/* 71 */     i = 31 * i + ((this.value != null) ? this.value.hashCode() : 0);
/* 72 */     return i;
/*    */   }
/*    */   
/*    */   String printNext() {
/* 76 */     if (this.next != null) {
/* 77 */       return " -> " + this.next;
/*    */     }
/* 79 */     return "";
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder stringBuilder = new StringBuilder();
/* 85 */     switch (this.type)
/*    */     { case 0:
/* 87 */         stringBuilder.append("LITERAL(" + this.value + ")");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 93 */         stringBuilder.append(printNext());
/*    */         
/* 95 */         return stringBuilder.toString(); }  stringBuilder.append(super.toString()); stringBuilder.append(printNext()); return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\parser\Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */