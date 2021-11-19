# Android_MVP_Practice

안드로이드 MVP패턴을 연습해 보았다.
M - MODEL  
V - VIEW  
P - PRESENTER  

사용자가 VIEW랑 상호작용을 하면 VIEW가 PRESENTER로 요청 이를 감지하고 MODEL로 PRESENTER가 요청, MODEL에서 PRESENTER로 응답 후  
VIEW가 변경된다.  
contract 인터페이스를 만든 뒤 view 마다 필요한 인터페이스를 정의한 후 각 class에 implements  
해주었다.  
  
  확실히 MVC패턴보다 코드가 깔끔해진걸 느낄 수 있었다.
