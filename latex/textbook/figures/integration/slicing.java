                  /*  File:  slicing.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class slicing extends Template {

     static {templateClass = new slicing() ; }

     public void setup() {
          filePrefix="slicing";
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;   // in inches
          ysize = 2.0 ;   // in inches
          xmin = -5 ;
          xmax = 55 ;
          ymin = -5 ;
          ymax = 55 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double dx = 3 ;
          int    nx = 9 ;
          double DX = 9 ;
          int    NX = 5 ;
          double dy = 3 ;
          int    ny = 15 ;
          double DY = 9 ;
          int    NY = 5 ;

          String Black = "0 0 0 1 setcmykcolor  " ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 1.5) ;
          fEnv("headLength", 4.5) ;
          fLine(xmin+3, 1.5*DY, xmax, 1.5*DY) ; 
          fTeXlabel(xmax, 1.5*DY-1 , "tr", "$u$") ;
          fLine(1.5*DX, ymin+3, 1.5*DX, ymax) ;
          fTeXlabel(1.5*DX-1, ymax, "tr", "$v$") ;
          



          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          for (int n1 = 0; n1 <= NX ; n1++) {
               fLine(n1*DX, 0, n1*DX, NY*DY) ;
          }


          canvas.append( new fPsWrite(Red+"\n")) ;
          for (int n2 = 0; n2 <= NY ; n2++) {
               fLine(0, n2*DY, NX*DX, n2*DY) ;
          }

          double h = 3.0 ;
          double hh = 3.5 ;
          double w = 1.8 ;
          double l = 3.0 ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0) ;
          fEnv("headLength", 6.0) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fLine(3*DX, 5*DY + h-w, 3*DX, 5*DY + h+w ) ;
          fLine(4*DX, 5*DY + h-w, 4*DX, 5*DY + h+w ) ;
          fArrow(3*DX - 1.7*l, 5*DY + h, 3*DX, 5*DY + h) ;
          fArrow(4*DX + 1.7*l, 5*DY + h, 4*DX, 5*DY + h) ;
          fTeXlabel(3.5*DX, 5*DY + h, "cc", "$\\dee{u}$") ;

          fLine(0, -h-w, 0, -h+w ) ;
          fLine(5*DX, -h-w, 5*DX, -h+w ) ;
          fArrow(0, -h, 2.5*DX-1.2*w,  -h) ;
          fArrow(5*DX, -h, 2.5*DX+1.2*w,  -h) ;
          fTeXlabel(2.5*DX,  -h, "cc", "$W$") ;

          fLine(5*DX + hh-w, 3*DY, 5*DX + hh+w, 3*DY ) ;
          fLine(5*DX + hh-w, 4*DY, 5*DX + hh+w, 4*DY ) ;
          fArrow(5*DX + hh, 4*DY + 1.7*l , 5*DX + hh, 4*DY) ;
          fArrow(5*DX + hh, 3*DY - 1.7*l , 5*DX + hh, 3*DY) ;
          fTeXlabel(5*DX + 1.3*h, 3.5*DY, "cc", "$\\dee{v}$") ;


          fLine(-hh-w, 0, -hh+w, 0) ;
          fLine(-hh-w, 5*DY, -hh+w, 5*DY ) ;
          fArrow(-hh, 0 , -hh, 2.5*DY-1.7*w) ;
          fArrow(-hh, 5*DY, -hh, 2.5*DY+1.7*w) ;
          fTeXlabel(-hh, 2.5*DY, "cc", "$H$") ;






     }
}