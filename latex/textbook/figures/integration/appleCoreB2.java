                  /*  File:  appleCoreB2.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class appleCoreB2 extends Template {

     static {templateClass = new appleCoreB2() ; }

     public void setup() {
          filePrefix = "appleCoreB2" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 7*0.2 ;      // in inches
          ysize = 7*0.2 ;   // in inches
          xmin = -1 ;
          xmax = 6 ;
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
          fTeXlabel(-0.1, ymax, "tr", "$z$") ;
          double beta = 70 ; double betaRad = beta*Math.PI/180 ;
          double a = 5 ;  
          double b = a*Math.cos(betaRad) ;

          double n = 6 ;
          double dth  = beta/n ;
          double th2 = 2*dth ; double th2Rad = th2*Math.PI/180 ;
          double th1 = 1*dth ; double th1Rad = th1*Math.PI/180 ;
          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0,0, a,a, 0, beta, WEDGE+FILLED) ;

//          fEnv("psFillGray", 0.7) ;
//          fEllipticalArc(0,0, a,a, th1, th2, WEDGE+FILLED) ;

          fEnv("psFillGray", 1.0) ;
          { 
            double[] xlist = { 0, b, b, 0} ;
            double[] ylist = { 0, 0, a, a} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


          fEnv("psFillGray", 1.0) ;
          fEnv("lineWidth", 0.5) ;
          double th = beta ;  double xv, yv ;
          for ( int i=1; i <= 1 ; i++ ) {
               xv = 6*Math.cos(th*Math.PI/180);
               yv = 6*Math.sin(th*Math.PI/180);
               fLine(0,0,xv,yv) ;
               th += dth ;
          } 

          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fLine(0,a*Math.sin(betaRad),  b,a*Math.sin(betaRad)) ;
          fEllipticalArc(0,0, 1,1, beta, 90, OPEN) ;


          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fEllipticalArc(0,0, a,a, 0, beta, OPEN) ;
          fLine(b,0,  b,a*Math.sin(betaRad)) ;
          fLine(b,0,  a,0) ;

//          fEnv("lineWidth", 1.5) ;
//          canvas.append( new fPsWrite(Blue+"\n")) ;
//          fEllipticalArc(0,0, a,a,  th1, th2, OPEN) ;
//
//          fLine(0,0, a*Math.cos(th1Rad),a*Math.sin(th1Rad)) ;
//          fLine(0,0, a*Math.cos(th2Rad),a*Math.sin(th2Rad)) ;


          fTeXlabel(6*Math.cos(betaRad)+0.1, 6*Math.sin(betaRad), "bl", 
                                              "$\\varphi=\\arcsin\\frac{b}{a}$") ;
//          fTeXlabel(6.1*Math.cos(th2Rad),  6.1*Math.sin(th2Rad), "bl", 
//                                                          "$\\scriptstyle\\varphi$") ;
//          fTeXlabel(6.1*Math.cos(th1Rad),  6.1*Math.sin(th1Rad), "bl", 
//                                          "$\\scriptstyle\\varphi+\\dee{\\varphi}$") ;
          fTeXlabel(0.5*b-0.05,0.5*a*Math.sin(betaRad), "br",    "$a$") ;
          fTeXlabel(0.5*b,  a*Math.sin(betaRad)+0.1, "bc",    "$b$") ;
          fTeXlabel(0.27,  1.2, "bc",    "$\\scriptstyle\\varphi$") ;

     }
}
