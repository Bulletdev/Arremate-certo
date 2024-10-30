/*     */ package ch.qos.logback.core.subst;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Node
/*     */ {
/*     */   a type;
/*     */   Object payload;
/*     */   Object defaultPart;
/*     */   Node next;
/*     */   
/*     */   enum a
/*     */   {
/*  19 */     a, b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node(a parama, Object paramObject) {
/*  28 */     this.type = parama;
/*  29 */     this.payload = paramObject;
/*     */   }
/*     */   
/*     */   public Node(a parama, Object paramObject1, Object paramObject2) {
/*  33 */     this.type = parama;
/*  34 */     this.payload = paramObject1;
/*  35 */     this.defaultPart = paramObject2;
/*     */   }
/*     */   
/*     */   void append(Node paramNode) {
/*  39 */     if (paramNode == null)
/*     */       return; 
/*  41 */     Node node = this;
/*     */     while (true) {
/*  43 */       if (node.next == null) {
/*  44 */         node.next = paramNode;
/*     */         return;
/*     */       } 
/*  47 */       node = node.next;
/*     */     } 
/*     */   } public String toString() {
/*     */     StringBuilder stringBuilder1;
/*     */     StringBuilder stringBuilder2;
/*     */     String str;
/*  53 */     switch (null.u[this.type.ordinal()]) {
/*     */       case 1:
/*  55 */         return "Node{type=" + this.type + ", payload='" + this.payload + "'}";
/*     */       case 2:
/*  57 */         stringBuilder1 = new StringBuilder();
/*  58 */         stringBuilder2 = new StringBuilder();
/*  59 */         if (this.defaultPart != null) {
/*  60 */           recursive((Node)this.defaultPart, stringBuilder2);
/*     */         }
/*  62 */         recursive((Node)this.payload, stringBuilder1);
/*  63 */         str = "Node{type=" + this.type + ", payload='" + stringBuilder1.toString() + "'";
/*  64 */         if (this.defaultPart != null)
/*  65 */           str = str + ", defaultPart=" + stringBuilder2.toString(); 
/*  66 */         str = str + '}';
/*  67 */         return str;
/*     */     } 
/*  69 */     return null;
/*     */   }
/*     */   
/*     */   public void dump() {
/*  73 */     System.out.print(toString());
/*  74 */     System.out.print(" -> ");
/*  75 */     if (this.next != null) {
/*  76 */       this.next.dump();
/*     */     } else {
/*  78 */       System.out.print(" null");
/*     */     } 
/*     */   }
/*     */   
/*     */   void recursive(Node paramNode, StringBuilder paramStringBuilder) {
/*  83 */     Node node = paramNode;
/*  84 */     while (node != null) {
/*  85 */       paramStringBuilder.append(node.toString()).append(" --> ");
/*  86 */       node = node.next;
/*     */     } 
/*  88 */     paramStringBuilder.append("null ");
/*     */   }
/*     */   
/*     */   public void setNext(Node paramNode) {
/*  92 */     this.next = paramNode;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  97 */     if (this == paramObject)
/*  98 */       return true; 
/*  99 */     if (paramObject == null || getClass() != paramObject.getClass()) {
/* 100 */       return false;
/*     */     }
/* 102 */     Node node = (Node)paramObject;
/*     */     
/* 104 */     if (this.type != node.type)
/* 105 */       return false; 
/* 106 */     if ((this.payload != null) ? !this.payload.equals(node.payload) : (node.payload != null))
/* 107 */       return false; 
/* 108 */     if ((this.defaultPart != null) ? !this.defaultPart.equals(node.defaultPart) : (node.defaultPart != null))
/* 109 */       return false; 
/* 110 */     if ((this.next != null) ? !this.next.equals(node.next) : (node.next != null)) {
/* 111 */       return false;
/*     */     }
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 118 */     int i = (this.type != null) ? this.type.hashCode() : 0;
/* 119 */     i = 31 * i + ((this.payload != null) ? this.payload.hashCode() : 0);
/* 120 */     i = 31 * i + ((this.defaultPart != null) ? this.defaultPart.hashCode() : 0);
/* 121 */     i = 31 * i + ((this.next != null) ? this.next.hashCode() : 0);
/* 122 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\subst\Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */