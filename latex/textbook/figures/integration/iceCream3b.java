                  /*  File:  iceCream3b.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class iceCream3b extends Template {

     static {templateClass = new iceCream3b() ; }

     public void setup() {
          filePrefix = "iceCream3b" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6*0.2 ;      // in inches
          ysize = 7*0.2 ;   // in inches
          xmin = -1 ;
          xmax = 5 ;
          ymin = -1 ;
          ymax = 6 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(-0.1, ymax, "tr", "$z$") ;
          double beta = 45 ; double betaRad = beta*Math.PI/180 ;
          double a = 5 ;  

          double n = 5 ;
          double dth  = (90-beta)/n ;
          double th2 = 90-3*dth ; double th2Rad = th2*Math.PI/180 ;
          double th1 = 90-4*dth ; double th1Rad = th1*Math.PI/180 ;
          double nr = 6 ;
          double dr  = a/nr ;
          double r1 = 5*dr ;
          double r2 = 6*dr ;

          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0,0, a,a, beta, 90, WEDGE+FILLED) ;

          fEnv("psFillGray", 0.7) ;
          fEllipticalArc(0,0, a,a, th1, th2, WEDGE+FILLED) ;

          fEnv("psFillGray", 0.0) ;
          fEllipticalArc(0,0, r2,r2, th1, th2, WEDGE+FILLED) ;

          fEnv("psFillGray", 0.7) ;
          fEllipticalArc(0,0, r1,r1, th1, th2, WEDGE+FILLED) ;

          r1 = 0*dr ;
          r2 = 1*dr ;

          fEnv("psFillGray", 0.0) ;
          fEllipticalArc(0,0, r2,r2, th1, th2, WEDGE+FILLED) ;




          fEnv("psFillGray", 1.0) ;
          fEnv("lineWidth", 0.5) ;
          double th = 90-dth ;  double xv, yv ;
          for ( int i=1; i <= n ; i++ ) {
               xv = 6*Math.cos(th*Math.PI/180);
               yv = 6*Math.sin(th*Math.PI/180);
               fLine(0,0,xv,yv) ;
               th -= dth ;
          } 
          double R = dr ;  
          for ( int i=1; i <= nr ; i++ ) {
               fEllipticalArc(0,0, R,R, th1, th2, OPEN) ;
               R += dr ;
          } 
          fEllipticalArc(0,0, a,a, beta-dth, 90+dth, OPEN) ;


          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fEllipticalArc(0,0, a,a, beta, 90, OPEN) ;
          fLine(0,0,   a*Math.cos(betaRad),a*Math.sin(betaRad)) ;
          fLine(0,0,  0,a) ;

          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(0,0, a,a,  th1, th2, OPEN) ;

          fLine(0,0, a*Math.cos(th1Rad),a*Math.sin(th1Rad)) ;
          fLine(0,0, a*Math.cos(th2Rad),a*Math.sin(th2Rad)) ;


          fTeXlabel(6*Math.cos(betaRad)+0.1, 6*Math.sin(betaRad), "bl", 
                                                               "$\\varphi=\\beta$") ;
//          fTeXlabel(6.1*Math.cos(th2Rad),  6.1*Math.sin(th2Rad), "bl", 
//                                                          "$\\scriptstyle\\varphi$") ;
//          fTeXlabel(6.1*Math.cos(th1Rad),  6.1*Math.sin(th1Rad), "bl", 
//                                          "$\\scriptstyle\\varphi+\\dee{\\varphi}$") ;
          fTeXlabel(-1,  0.97*a, "cr",    "$\\rho=a$") ;

     }
}
