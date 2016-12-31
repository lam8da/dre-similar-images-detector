package jp.thisnor.dre.pixeldup;

class PixelDupData {
  final byte[] hash;
  final int width;
  final int height;
  final int fileSize;

  PixelDupData(byte[] hash, int width, int height, int fileSize) {
    this.hash = hash;
    this.width = width;
    this.height = height;
    this.fileSize = fileSize;
  }
}
