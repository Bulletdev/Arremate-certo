package com.sun.jna.platform.win32.COM;

import com.sun.jna.Pointer;

public interface IMoniker extends IPersistStream {
  void BindToObject();
  
  void BindToStorage();
  
  void Reduce();
  
  void ComposeWith();
  
  void Enum();
  
  void IsEqual();
  
  void Hash();
  
  void IsRunning();
  
  void GetTimeOfLastChange();
  
  void Inverse();
  
  void CommonPrefixWith();
  
  String GetDisplayName(Pointer paramPointer1, Pointer paramPointer2);
  
  void ParseDisplayName();
  
  void IsSystemMoniker();
  
  void RelativePathTo();
}


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\IMoniker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */