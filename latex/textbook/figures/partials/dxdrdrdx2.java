                  /*  File:  dxdrdrdx2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class dxdrdrdx2 extends Template {

     static {templateClass = new dxdrdrdx2() ; }

     public void setup() {
          filePrefix = "dxdrdrdx2" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.8 ;      
          ysize = 1.8 ;   
          xmin = -10 ;
          xmax = 90 ;
          ymin = -10 ;
          ymax = 90 ;
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
          double rr =1.7 ;
          double r = 60 ;
          double R = 80 ;
          double t1 = 40 ;
          double t2 = 50 ;
          double t3 = 20 ;
          double t1r = t1*Math.PI/180 ;
          double t2r = t2*Math.PI/180 ;
          double t3r = t3*Math.PI/180 ;
          double y = r*Math.sin(t2r) ;
          double x = Math.sqrt(R*R-y*y) ;
          double x1 = Math.sqrt(r*r-y*y) ;

          fEnv("lineWidth", 1.0) ;
          fEllipticalArc(0,0, r,r, 10, 80, OPEN) ;
          fEllipticalArc(0,0, R,R, 10, 80, OPEN) ;

          fEnv("lineWidth", 0.5) ;

          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
//          fLine(0, y, x,y ) ;
//          fTeXlabel(-2,y, "cr", "$y$") ;


          fArrow((r-13)*Math.cos(t3r),(r-13)*Math.sin(t3r), 
                              r*Math.cos(t3r), r*Math.sin(t3r)) ;
          fArrow((R+13)*Math.cos(t3r),(R+13)*Math.sin(t3r), 
                              R*Math.cos(t3r), R*Math.sin(t3r)) ;
          fTeXlabel((r+R)*Math.cos(t3r)/2,(r+R)*Math.sin(t3r)/2, "cc", "$\\dee{r}$") ;


          fLine(r*Math.cos(t2r),y-2, r*Math.cos(t2r),y-12);
          fLine(x,y-2, x,y-12);
          fArrow(r*Math.cos(t2r)-13,y-7, r*Math.cos(t2r),y-7) ;
          fArrow(x+13,y-7, x,y-7) ;
          fEnv("psFillGray", 1.0) ;
          fDisk((r*Math.cos(t2r)+x)/2,y-7, 8,6, FILLED) ;
          fTeXlabel((r*Math.cos(t2r)+x)/2,y-7, "cc", "$\\dee{x}$") ;

          String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Orange+"\n")) ;
          fLine(r*Math.cos(t2r), r*Math.sin(t2r), R*Math.cos(t2r), R*Math.sin(t2r)) ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fLine(r*Math.cos(t2r), r*Math.sin(t2r), x, y) ;

          fEnv("psFillGray", 0.0) ;
          fDisk(x1,y, rr, rr, FILLED) ;
          fTeXlabel(x1-3,y-0.5, "rc", "$\\scriptstyle(x_0,y_0)$") ;

          
     }
}
