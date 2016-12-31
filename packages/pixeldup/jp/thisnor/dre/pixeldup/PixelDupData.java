package jp.thisnor.dre.pixeldup;

class PixelDupData {
  final byte[] hash;

  // The following fields are currently not used.
  final int width;
  final int height;
  final long fileSize;

  PixelDupData(byte[] hash) {
    this.hash = hash;
    this.width = 0;
    this.height = 0;
    this.fileSize = 0;
  }

  PixelDupData(byte[] hash, int width, int height, long fileSize) {
    this.hash = hash;
    this.width = width;
    this.height = height;
    this.fileSize = fileSize;
  }
}
