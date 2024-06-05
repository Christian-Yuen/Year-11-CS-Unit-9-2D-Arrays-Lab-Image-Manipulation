package code;

import image.APImage;
import image.Pixel;

public class ImageManipulation {

    /** CHALLENGE 0: Display Image
     *  Write a statement that will display the image in a window
     */
    public static void main(String[] args) {
        APImage picture = new APImage("cyberpunk2077.jpg");
        picture.show();
        edgeDetection("cyberpunk2077.jpg", 35);
    }

    /** CHALLENGE ONE: Grayscale
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a grayscale copy of the image
     *
     * To convert a colour image to grayscale, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * Set the red, green, and blue components to this average value. */
    public static void grayScale(String pathOfFile) {
        APImage picture = new APImage(pathOfFile);
        for (int i = 0; i < picture.getWidth(); i++) {
            for (int j = 0; j < picture.getHeight(); j++) {
                Pixel pixel = picture.getPixel(i, j);
                int average = getAverageColour(pixel);
                pixel.setBlue(average);
                pixel.setRed(average);
                pixel.setGreen(average);
                picture.setPixel(i, j, pixel);
            }
        }
        picture.draw();
    }

    /** A helper method that can be used to assist you in each challenge.
     * This method simply calculates the average of the RGB values of a single pixel.
     * @param pixel
     * @return the average RGB value
     */
    private static int getAverageColour(Pixel pixel) {
        int blue = pixel.getBlue();
        int red = pixel.getRed();
        int green = pixel.getGreen();
        return (blue + red + green) / 3;
    }

    /** CHALLENGE TWO: Black and White
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a black and white copy of the image
     *
     * To convert a colour image to black and white, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * If the average is less than 128, set the pixel to black
     * If the average is equal to or greater than 128, set the pixel to white */
    public static void blackAndWhite(String pathOfFile) {
        APImage picture = new APImage(pathOfFile);
        for (int i = 0; i < picture.getWidth(); i++) {
            for (int j = 0; j < picture.getHeight(); j++) {
                Pixel pixel = picture.getPixel(i, j);
                int average = getAverageColour(pixel);
                if (average<128){
                    pixel.setBlue(0);
                    pixel.setRed(0);
                    pixel.setGreen(0);
                }
                else{
                    pixel.setBlue(255);
                    pixel.setRed(255);
                    pixel.setGreen(255);
                }

                picture.setPixel(i, j, pixel);
            }
        }
        picture.draw();
    }

    /** CHALLENGE Three: Edge Detection
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: an outline of the image. The amount of information will correspond to the threshold.
     *
     * Edge detection is an image processing technique for finding the boundaries of objects within images.
     * It works by detecting discontinuities in brightness. Edge detection is used for image segmentation
     * and data extraction in areas such as image processing, computer vision, and machine vision.
     *
     * There are many different edge detection algorithms. We will use a basic edge detection technique
     * For each pixel, we will calculate ...
     * 1. The average colour value of the current pixel
     * 2. The average colour value of the pixel to the left of the current pixel
     * 3. The average colour value of the pixel below the current pixel
     * If the difference between 1. and 2. OR if the difference between 1. and 3. is greater than some threshold value,
     * we will set the current pixel to black. This is because an absolute difference that is greater than our threshold
     * value should indicate an edge and thus, we colour the pixel black.
     * Otherwise, we will set the current pixel to white
     * NOTE: We want to be able to apply edge detection using various thresholds
     * For example, we could apply edge detection to an image using a threshold of 20 OR we could apply
     * edge detection to an image using a threshold of 35
     *  */
    public static void edgeDetection(String pathToFile, int threshold) {
        APImage picture = new APImage(pathToFile);
        APImage result = new APImage(pathToFile);
        int height = picture.getHeight();
        int width = picture.getWidth();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Pixel pixel = picture.getPixel(j, i);
                int one = getAverageColour(pixel);
                int two = 0;
                int three = 0;

                if (Math.abs(one - two) > threshold || Math.abs(one - three) > threshold) {
                    pixel.setRed(0);
                    pixel.setBlue(0);
                    pixel.setGreen(0);
                }
                else {
                    pixel.setRed(255);
                    pixel.setBlue(255);
                    pixel.setGreen(255);
                }

                result.setPixel(j, i, pixel);
            }
        }
        result.draw();
    }


    /** CHALLENGE Four: Reflect Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image reflected about the y-axis
     *
     */
    public static void reflectImage(String pathToFile) {

    }

    /** CHALLENGE Five: Rotate Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image rotated 90 degrees CLOCKWISE
     *
     *  */
    public static void rotateImage(String pathToFile) {

    }

}
