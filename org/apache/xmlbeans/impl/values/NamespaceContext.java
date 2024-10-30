/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.common.PrefixResolver;
/*     */ import org.apache.xmlbeans.xml.stream.StartElement;
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
/*     */ public class NamespaceContext
/*     */   implements PrefixResolver
/*     */ {
/*     */   private static final int TYPE_STORE = 1;
/*     */   private static final int XML_OBJECT = 2;
/*     */   private static final int MAP = 3;
/*     */   private static final int START_ELEMENT = 4;
/*     */   private static final int RESOLVER = 5;
/*     */   private Object _obj;
/*     */   private int _code;
/*     */   
/*     */   public NamespaceContext(Map paramMap) {
/*  43 */     this._code = 3;
/*  44 */     this._obj = paramMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public NamespaceContext(TypeStore paramTypeStore) {
/*  49 */     this._code = 1;
/*  50 */     this._obj = paramTypeStore;
/*     */   }
/*     */ 
/*     */   
/*     */   public NamespaceContext(XmlObject paramXmlObject) {
/*  55 */     this._code = 2;
/*  56 */     this._obj = paramXmlObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public NamespaceContext(StartElement paramStartElement) {
/*  61 */     this._code = 4;
/*  62 */     this._obj = paramStartElement;
/*     */   }
/*     */ 
/*     */   
/*     */   public NamespaceContext(PrefixResolver paramPrefixResolver) {
/*  67 */     this._code = 5;
/*  68 */     this._obj = paramPrefixResolver;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class NamespaceContextStack
/*     */   {
/*     */     NamespaceContext current;
/*     */ 
/*     */     
/*  78 */     ArrayList stack = new ArrayList();
/*     */     
/*     */     final void push(NamespaceContext param1NamespaceContext) {
/*  81 */       this.stack.add(this.current);
/*  82 */       this.current = param1NamespaceContext;
/*     */     }
/*     */     
/*     */     final void pop() {
/*  86 */       this.current = this.stack.get(this.stack.size() - 1);
/*  87 */       this.stack.remove(this.stack.size() - 1);
/*     */     }
/*     */     
/*     */     private NamespaceContextStack() {} }
/*  91 */   private static ThreadLocal tl_namespaceContextStack = new ThreadLocal();
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   private static NamespaceContextStack getNamespaceContextStack() {
/*  95 */     NamespaceContextStack namespaceContextStack = tl_namespaceContextStack.get();
/*  96 */     if (namespaceContextStack == null) {
/*     */       
/*  98 */       namespaceContextStack = new NamespaceContextStack();
/*  99 */       tl_namespaceContextStack.set(namespaceContextStack);
/*     */     } 
/* 101 */     return namespaceContextStack;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void push(NamespaceContext paramNamespaceContext) {
/* 106 */     getNamespaceContextStack().push(paramNamespaceContext);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void pop() {
/* 111 */     NamespaceContextStack namespaceContextStack = getNamespaceContextStack();
/* 112 */     namespaceContextStack.pop();
/*     */     
/* 114 */     if (namespaceContextStack.stack.size() == 0) {
/* 115 */       tl_namespaceContextStack.set(null);
/*     */     }
/*     */   }
/*     */   
/*     */   public static PrefixResolver getCurrent() {
/* 120 */     return (getNamespaceContextStack()).current;
/*     */   }
/*     */   public String getNamespaceForPrefix(String paramString) {
/*     */     Object object;
/*     */     XmlCursor xmlCursor;
/* 125 */     if (paramString != null && paramString.equals("xml")) {
/* 126 */       return "http://www.w3.org/XML/1998/namespace";
/*     */     }
/* 128 */     switch (this._code) {
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 133 */         object = this._obj;
/* 134 */         if (Proxy.isProxyClass(object.getClass())) {
/* 135 */           object = Proxy.getInvocationHandler(object);
/*     */         }
/* 137 */         if (object instanceof TypeStoreUser) {
/* 138 */           return ((TypeStoreUser)object).get_store().getNamespaceForPrefix(paramString);
/*     */         }
/* 140 */         xmlCursor = ((XmlObject)this._obj).newCursor();
/* 141 */         if (xmlCursor != null) {
/*     */           
/* 143 */           if (xmlCursor.currentTokenType() == XmlCursor.TokenType.ATTR)
/* 144 */             xmlCursor.toParent();  
/* 145 */           try { return xmlCursor.namespaceForPrefix(paramString); }
/* 146 */           finally { xmlCursor.dispose(); }
/*     */         
/*     */         } 
/*     */       
/*     */       case 3:
/* 151 */         return (String)((Map)this._obj).get(paramString);
/*     */       
/*     */       case 1:
/* 154 */         return ((TypeStore)this._obj).getNamespaceForPrefix(paramString);
/*     */       
/*     */       case 4:
/* 157 */         return ((StartElement)this._obj).getNamespaceUri(paramString);
/*     */       
/*     */       case 5:
/* 160 */         return ((PrefixResolver)this._obj).getNamespaceForPrefix(paramString);
/*     */     } 
/*     */     
/* 163 */     assert false : "Improperly initialized NamespaceContext.";
/* 164 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\NamespaceContext.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */