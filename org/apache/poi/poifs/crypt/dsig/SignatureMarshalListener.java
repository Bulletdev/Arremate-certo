/*    */ package org.apache.poi.poifs.crypt.dsig;
/*    */ 
/*    */ import org.w3c.dom.Element;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ import org.w3c.dom.events.Event;
/*    */ import org.w3c.dom.events.EventListener;
/*    */ import org.w3c.dom.events.EventTarget;
/*    */ import org.w3c.dom.events.MutationEvent;
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
/*    */ public class SignatureMarshalListener
/*    */   implements SignatureConfig.SignatureConfigurable, EventListener
/*    */ {
/* 37 */   ThreadLocal<EventTarget> target = new ThreadLocal<EventTarget>();
/*    */   
/*    */   public void setEventTarget(EventTarget paramEventTarget) {
/* 40 */     this.target.set(paramEventTarget);
/*    */   }
/*    */   SignatureConfig signatureConfig;
/*    */   public void handleEvent(Event paramEvent) {
/* 44 */     if (!(paramEvent instanceof MutationEvent))
/* 45 */       return;  MutationEvent mutationEvent = (MutationEvent)paramEvent;
/* 46 */     EventTarget eventTarget = mutationEvent.getTarget();
/* 47 */     if (!(eventTarget instanceof Element))
/* 48 */       return;  handleElement((Element)eventTarget);
/*    */   }
/*    */   
/*    */   public void handleElement(Element paramElement) {
/* 52 */     EventTarget eventTarget = this.target.get();
/* 53 */     String str = this.signatureConfig.getPackageSignatureId();
/* 54 */     if (paramElement.hasAttribute("Id")) {
/* 55 */       paramElement.setIdAttribute("Id", true);
/*    */     }
/*    */     
/* 58 */     setListener(eventTarget, this, false);
/* 59 */     if (str.equals(paramElement.getAttribute("Id"))) {
/* 60 */       paramElement.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:mdssi", "http://schemas.openxmlformats.org/package/2006/digital-signature");
/*    */     }
/* 62 */     setPrefix(paramElement);
/* 63 */     setListener(eventTarget, this, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setListener(EventTarget paramEventTarget, EventListener paramEventListener, boolean paramBoolean) {
/* 68 */     String str = "DOMSubtreeModified";
/* 69 */     boolean bool = false;
/* 70 */     if (paramBoolean) {
/* 71 */       paramEventTarget.addEventListener(str, paramEventListener, bool);
/*    */     } else {
/* 73 */       paramEventTarget.removeEventListener(str, paramEventListener, bool);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void setPrefix(Node paramNode) {
/* 78 */     String str = this.signatureConfig.getNamespacePrefixes().get(paramNode.getNamespaceURI());
/* 79 */     if (str != null && paramNode.getPrefix() == null) {
/* 80 */       paramNode.setPrefix(str);
/*    */     }
/*    */     
/* 83 */     NodeList nodeList = paramNode.getChildNodes();
/* 84 */     for (byte b = 0; b < nodeList.getLength(); b++) {
/* 85 */       setPrefix(nodeList.item(b));
/*    */     }
/*    */   }
/*    */   
/*    */   public void setSignatureConfig(SignatureConfig paramSignatureConfig) {
/* 90 */     this.signatureConfig = paramSignatureConfig;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\SignatureMarshalListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */