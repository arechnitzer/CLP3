                  /*  File:  OE01DQ8c.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE01DQ8c extends Template {

     static {templateClass = new OE01DQ8c() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "OE01DQ8c" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.0 ;    
          ysize = 5.0 ;  
          xmin = -3 ;
          xmax =  4 ;
          ymin = -3 ;
          ymax =  4 ;
          topmargin = -0.5 ;   // in inches
          bottommargin = -0.8 ;   // in inches
          leftmargin = -0.75 ;   // in inches
          rightmargin = -0.75 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 45 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double xm = 1.5 ;
          double ym = 1.5 ;
          double zm = 1.5 ;

          fEnv("lineWidth", 0.5) ;
          double z1 = 0.25 ; double z2 = 0.75 ;
          double y1 = 0.25 ; double y2 = 0.75 ;
          fLine3d(0,0,0, 0,0,z1) ;
          fLine3d(0,0,z2, 0,0,zm) ;
          fLine3d(0,0,0, 0,y1,0) ;
          fLine3d(0,y2,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
           fLine3d(0,0,z1, 0,0,z2) ;
          fLine3d(0,y1,0, 0,y2,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel3d(0,0,zm+0.1, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.1,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-0.02,-0.02, "tr", "$x$") ;


          fEnv("lineWidth", 1.0) ;
          fLine3d(0,1,1, 1,1,0) ;
          fLine3d(0,1,1, 1,1,1) ;
          fLine3d(1,0,1, 0,1,1) ;

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine3d(1,1,0, 1,1,1) ;     
          fLine3d(1,0,1, 1,1,0) ;
          fLine3d(1,0,1, 1,1,1) ;
     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fLine(X1,Y1,X2,Y2) ;
     }



     public void fTeXlabel3d(double xl, double yl, double zl,
                         String biase, String label) {
          double X = xl*x0+yl;
          double Y = xl*x1+zl;
          fTeXlabel(X, Y, biase, label) ;
     }

}







