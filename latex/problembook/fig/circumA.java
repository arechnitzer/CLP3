                  /*  File:  circumA.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class circumA extends Template {

     static {templateClass = new circumA() ; }

     public void setup() {
          filePrefix = "circumA" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
          xmin = -200 ;
          xmax =  200 ;
          ymin = -200 ;
          ymax =  200 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double R = 200 ;
          double r = 7 ;
          double l=13 ;
          double h = 8 ;
          double th1 = 30; double th1Rad = th1*Math.PI/180 ;
          double th2 = 120; double th2Rad = th2*Math.PI/180 ;
          double x1 = -R*Math.cos(th1Rad) ;  double y1 = -R*Math.sin(th1Rad) ;
          double x2 = R*Math.cos(th1Rad)  ;  double y2 = -R*Math.sin(th1Rad) ;
          double x3 = R*Math.cos(th2Rad)  ;  double y3 =  R*Math.sin(th2Rad) ;
          double mx1 = 0.5*(x1+x2) ;  double my1 = 0.5*(y1+y2) ; 
          double mx2 = 0.5*(x2+x3) ;  double my2 = 0.5*(y2+y3) ; 
               double L2 = Math.sqrt(mx2*mx2+my2*my2) ;
          double mx3 = 0.5*(x3+x1) ;  double my3 = 0.5*(y3+y1) ; 
               double L3 = Math.sqrt(mx3*mx3+my3*my3) ;

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;

          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fDisk(0,0, R, R) ;

          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;
          fEnv("psFillColor", Black) ;
          fDisk(x2,y2, r,r, FILLED) ;  fTeXlabel(x2,y2, "tl", "$A$") ;
          fDisk(x3,y3, r,r, FILLED) ;  fTeXlabel(x3-5,y3, "br", "$B$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          fEnv("psFillColor", Blue) ;
          fArrow(x1,y1,  x2,y2) ;
          fLine(x2,y2,  x3,y3) ;
          fArrow(x1,y1,  x3,y3) ;
          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Orange+"\n")) ;
          fEnv("psFillColor", Black) ;
          fDisk(mx1,my1, r,r, FILLED) ;
          fDisk(mx3,my3, r,r, FILLED) ;
          fDisk(0,0, r,r, FILLED)   ;  fTeXlabel(-0.5,-18, "tr", "$C$") ;
          fEnv("psFillColor", Orange) ;
          fArrow(x1,y1, mx1,my1) ;  fTeXlabel(mx1+2,my1-12, "tc", "$P_A$") ;
          fArrow(x1,y1, mx3,my3) ;  fTeXlabel(mx3-7,my3, "cr", "$P_B$") ;
          fArrow(x1,y1,0.00*x1,0.00*y1) ;


          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          fEnv("lineWidth", 0.5) ;
          fDisk(x1,y1, r,r, FILLED) ;  fTeXlabel(x1-7,y1, "tr", "$O$") ;
//               fLine(x2,y2,0.03*x2,0.03*y2) ;
//               fLine(x3,y3,0.03*x3,0.03*y3) ;
          fLine(0,0,  mx1,my1) ;
            fLine(mx1+l,my1, mx1+l,my1+l) ;
            fLine(mx1,my1+l, mx1+l,my1+l) ;
//        fLine(0,0,  mx2,my2) ;
//          fLine(mx2*(1-l/L2),my2*(1-l/L2), mx2*(1-l/L2)+my2*l/L2,my2*(1-l/L2)-mx2*l/L2);
//          fLine(mx2+my2*l/L2,my2-mx2*l/L2, mx2*(1-l/L2)+my2*l/L2,my2*(1-l/L2)-mx2*l/L2);
          fLine(0,0,  mx3,my3) ;
            fLine(mx3*(1-l/L3),my3*(1-l/L3), mx3*(1-l/L3)+my3*l/L3,my3*(1-l/L3)-mx3*l/L3);
            fLine(mx3+my3*l/L3,my3-mx3*l/L3, mx3*(1-l/L3)+my3*l/L3,my3*(1-l/L3)-mx3*l/L3);

//          fLine(0.5*x2-h*Math.sin(th1Rad),0.5*y2-h*Math.cos(th1Rad),   
//                0.5*x2+h*Math.sin(th1Rad),0.5*y2+h*Math.cos(th1Rad) ) ;
//          fLine(0.5*x1-h*Math.sin(th1Rad),0.5*y1+h*Math.cos(th1Rad),   
//                0.5*x1+h*Math.sin(th1Rad),0.5*y1-h*Math.cos(th1Rad) ) ;
//          fLine(0.5*x3-h*Math.cos(th1Rad),0.5*y3-h*Math.sin(th1Rad),   
//                0.5*x3+h*Math.cos(th1Rad),0.5*y3+h*Math.sin(th1Rad) ) ;

   
     }
}
