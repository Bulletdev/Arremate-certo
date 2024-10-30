package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlurEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillOverlayEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGlowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInnerShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTReflectionEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSoftEdgesEffect;

public class CTEffectListImpl extends XmlComplexContentImpl implements CTEffectList {
  private static final b BLUR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blur");
  
  private static final b FILLOVERLAY$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "fillOverlay");
  
  private static final b GLOW$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "glow");
  
  private static final b INNERSHDW$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "innerShdw");
  
  private static final b OUTERSHDW$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "outerShdw");
  
  private static final b PRSTSHDW$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "prstShdw");
  
  private static final b REFLECTION$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "reflection");
  
  private static final b SOFTEDGE$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "softEdge");
  
  public CTEffectListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTBlurEffect getBlur() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlurEffect cTBlurEffect = null;
      cTBlurEffect = (CTBlurEffect)get_store().find_element_user(BLUR$0, 0);
      if (cTBlurEffect == null)
        return null; 
      return cTBlurEffect;
    } 
  }
  
  public boolean isSetBlur() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BLUR$0) != 0);
    } 
  }
  
  public void setBlur(CTBlurEffect paramCTBlurEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlurEffect cTBlurEffect = null;
      cTBlurEffect = (CTBlurEffect)get_store().find_element_user(BLUR$0, 0);
      if (cTBlurEffect == null)
        cTBlurEffect = (CTBlurEffect)get_store().add_element_user(BLUR$0); 
      cTBlurEffect.set((XmlObject)paramCTBlurEffect);
    } 
  }
  
  public CTBlurEffect addNewBlur() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlurEffect cTBlurEffect = null;
      cTBlurEffect = (CTBlurEffect)get_store().add_element_user(BLUR$0);
      return cTBlurEffect;
    } 
  }
  
  public void unsetBlur() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLUR$0, 0);
    } 
  }
  
  public CTFillOverlayEffect getFillOverlay() {
    synchronized (monitor()) {
      check_orphaned();
      CTFillOverlayEffect cTFillOverlayEffect = null;
      cTFillOverlayEffect = (CTFillOverlayEffect)get_store().find_element_user(FILLOVERLAY$2, 0);
      if (cTFillOverlayEffect == null)
        return null; 
      return cTFillOverlayEffect;
    } 
  }
  
  public boolean isSetFillOverlay() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FILLOVERLAY$2) != 0);
    } 
  }
  
  public void setFillOverlay(CTFillOverlayEffect paramCTFillOverlayEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTFillOverlayEffect cTFillOverlayEffect = null;
      cTFillOverlayEffect = (CTFillOverlayEffect)get_store().find_element_user(FILLOVERLAY$2, 0);
      if (cTFillOverlayEffect == null)
        cTFillOverlayEffect = (CTFillOverlayEffect)get_store().add_element_user(FILLOVERLAY$2); 
      cTFillOverlayEffect.set((XmlObject)paramCTFillOverlayEffect);
    } 
  }
  
  public CTFillOverlayEffect addNewFillOverlay() {
    synchronized (monitor()) {
      check_orphaned();
      CTFillOverlayEffect cTFillOverlayEffect = null;
      cTFillOverlayEffect = (CTFillOverlayEffect)get_store().add_element_user(FILLOVERLAY$2);
      return cTFillOverlayEffect;
    } 
  }
  
  public void unsetFillOverlay() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILLOVERLAY$2, 0);
    } 
  }
  
  public CTGlowEffect getGlow() {
    synchronized (monitor()) {
      check_orphaned();
      CTGlowEffect cTGlowEffect = null;
      cTGlowEffect = (CTGlowEffect)get_store().find_element_user(GLOW$4, 0);
      if (cTGlowEffect == null)
        return null; 
      return cTGlowEffect;
    } 
  }
  
  public boolean isSetGlow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GLOW$4) != 0);
    } 
  }
  
  public void setGlow(CTGlowEffect paramCTGlowEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTGlowEffect cTGlowEffect = null;
      cTGlowEffect = (CTGlowEffect)get_store().find_element_user(GLOW$4, 0);
      if (cTGlowEffect == null)
        cTGlowEffect = (CTGlowEffect)get_store().add_element_user(GLOW$4); 
      cTGlowEffect.set((XmlObject)paramCTGlowEffect);
    } 
  }
  
  public CTGlowEffect addNewGlow() {
    synchronized (monitor()) {
      check_orphaned();
      CTGlowEffect cTGlowEffect = null;
      cTGlowEffect = (CTGlowEffect)get_store().add_element_user(GLOW$4);
      return cTGlowEffect;
    } 
  }
  
  public void unsetGlow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GLOW$4, 0);
    } 
  }
  
  public CTInnerShadowEffect getInnerShdw() {
    synchronized (monitor()) {
      check_orphaned();
      CTInnerShadowEffect cTInnerShadowEffect = null;
      cTInnerShadowEffect = (CTInnerShadowEffect)get_store().find_element_user(INNERSHDW$6, 0);
      if (cTInnerShadowEffect == null)
        return null; 
      return cTInnerShadowEffect;
    } 
  }
  
  public boolean isSetInnerShdw() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(INNERSHDW$6) != 0);
    } 
  }
  
  public void setInnerShdw(CTInnerShadowEffect paramCTInnerShadowEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTInnerShadowEffect cTInnerShadowEffect = null;
      cTInnerShadowEffect = (CTInnerShadowEffect)get_store().find_element_user(INNERSHDW$6, 0);
      if (cTInnerShadowEffect == null)
        cTInnerShadowEffect = (CTInnerShadowEffect)get_store().add_element_user(INNERSHDW$6); 
      cTInnerShadowEffect.set((XmlObject)paramCTInnerShadowEffect);
    } 
  }
  
  public CTInnerShadowEffect addNewInnerShdw() {
    synchronized (monitor()) {
      check_orphaned();
      CTInnerShadowEffect cTInnerShadowEffect = null;
      cTInnerShadowEffect = (CTInnerShadowEffect)get_store().add_element_user(INNERSHDW$6);
      return cTInnerShadowEffect;
    } 
  }
  
  public void unsetInnerShdw() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INNERSHDW$6, 0);
    } 
  }
  
  public CTOuterShadowEffect getOuterShdw() {
    synchronized (monitor()) {
      check_orphaned();
      CTOuterShadowEffect cTOuterShadowEffect = null;
      cTOuterShadowEffect = (CTOuterShadowEffect)get_store().find_element_user(OUTERSHDW$8, 0);
      if (cTOuterShadowEffect == null)
        return null; 
      return cTOuterShadowEffect;
    } 
  }
  
  public boolean isSetOuterShdw() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OUTERSHDW$8) != 0);
    } 
  }
  
  public void setOuterShdw(CTOuterShadowEffect paramCTOuterShadowEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTOuterShadowEffect cTOuterShadowEffect = null;
      cTOuterShadowEffect = (CTOuterShadowEffect)get_store().find_element_user(OUTERSHDW$8, 0);
      if (cTOuterShadowEffect == null)
        cTOuterShadowEffect = (CTOuterShadowEffect)get_store().add_element_user(OUTERSHDW$8); 
      cTOuterShadowEffect.set((XmlObject)paramCTOuterShadowEffect);
    } 
  }
  
  public CTOuterShadowEffect addNewOuterShdw() {
    synchronized (monitor()) {
      check_orphaned();
      CTOuterShadowEffect cTOuterShadowEffect = null;
      cTOuterShadowEffect = (CTOuterShadowEffect)get_store().add_element_user(OUTERSHDW$8);
      return cTOuterShadowEffect;
    } 
  }
  
  public void unsetOuterShdw() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OUTERSHDW$8, 0);
    } 
  }
  
  public CTPresetShadowEffect getPrstShdw() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetShadowEffect cTPresetShadowEffect = null;
      cTPresetShadowEffect = (CTPresetShadowEffect)get_store().find_element_user(PRSTSHDW$10, 0);
      if (cTPresetShadowEffect == null)
        return null; 
      return cTPresetShadowEffect;
    } 
  }
  
  public boolean isSetPrstShdw() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRSTSHDW$10) != 0);
    } 
  }
  
  public void setPrstShdw(CTPresetShadowEffect paramCTPresetShadowEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetShadowEffect cTPresetShadowEffect = null;
      cTPresetShadowEffect = (CTPresetShadowEffect)get_store().find_element_user(PRSTSHDW$10, 0);
      if (cTPresetShadowEffect == null)
        cTPresetShadowEffect = (CTPresetShadowEffect)get_store().add_element_user(PRSTSHDW$10); 
      cTPresetShadowEffect.set((XmlObject)paramCTPresetShadowEffect);
    } 
  }
  
  public CTPresetShadowEffect addNewPrstShdw() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetShadowEffect cTPresetShadowEffect = null;
      cTPresetShadowEffect = (CTPresetShadowEffect)get_store().add_element_user(PRSTSHDW$10);
      return cTPresetShadowEffect;
    } 
  }
  
  public void unsetPrstShdw() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRSTSHDW$10, 0);
    } 
  }
  
  public CTReflectionEffect getReflection() {
    synchronized (monitor()) {
      check_orphaned();
      CTReflectionEffect cTReflectionEffect = null;
      cTReflectionEffect = (CTReflectionEffect)get_store().find_element_user(REFLECTION$12, 0);
      if (cTReflectionEffect == null)
        return null; 
      return cTReflectionEffect;
    } 
  }
  
  public boolean isSetReflection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(REFLECTION$12) != 0);
    } 
  }
  
  public void setReflection(CTReflectionEffect paramCTReflectionEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTReflectionEffect cTReflectionEffect = null;
      cTReflectionEffect = (CTReflectionEffect)get_store().find_element_user(REFLECTION$12, 0);
      if (cTReflectionEffect == null)
        cTReflectionEffect = (CTReflectionEffect)get_store().add_element_user(REFLECTION$12); 
      cTReflectionEffect.set((XmlObject)paramCTReflectionEffect);
    } 
  }
  
  public CTReflectionEffect addNewReflection() {
    synchronized (monitor()) {
      check_orphaned();
      CTReflectionEffect cTReflectionEffect = null;
      cTReflectionEffect = (CTReflectionEffect)get_store().add_element_user(REFLECTION$12);
      return cTReflectionEffect;
    } 
  }
  
  public void unsetReflection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(REFLECTION$12, 0);
    } 
  }
  
  public CTSoftEdgesEffect getSoftEdge() {
    synchronized (monitor()) {
      check_orphaned();
      CTSoftEdgesEffect cTSoftEdgesEffect = null;
      cTSoftEdgesEffect = (CTSoftEdgesEffect)get_store().find_element_user(SOFTEDGE$14, 0);
      if (cTSoftEdgesEffect == null)
        return null; 
      return cTSoftEdgesEffect;
    } 
  }
  
  public boolean isSetSoftEdge() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SOFTEDGE$14) != 0);
    } 
  }
  
  public void setSoftEdge(CTSoftEdgesEffect paramCTSoftEdgesEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTSoftEdgesEffect cTSoftEdgesEffect = null;
      cTSoftEdgesEffect = (CTSoftEdgesEffect)get_store().find_element_user(SOFTEDGE$14, 0);
      if (cTSoftEdgesEffect == null)
        cTSoftEdgesEffect = (CTSoftEdgesEffect)get_store().add_element_user(SOFTEDGE$14); 
      cTSoftEdgesEffect.set((XmlObject)paramCTSoftEdgesEffect);
    } 
  }
  
  public CTSoftEdgesEffect addNewSoftEdge() {
    synchronized (monitor()) {
      check_orphaned();
      CTSoftEdgesEffect cTSoftEdgesEffect = null;
      cTSoftEdgesEffect = (CTSoftEdgesEffect)get_store().add_element_user(SOFTEDGE$14);
      return cTSoftEdgesEffect;
    } 
  }
  
  public void unsetSoftEdge() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SOFTEDGE$14, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTEffectListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */