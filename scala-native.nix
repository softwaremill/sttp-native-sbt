let
  pkgs = import <nixpkgs> { };
  stdenv = pkgs.stdenv;
in
rec {
  clangEnv = stdenv.mkDerivation rec {
    name = "clang-env";
    shellHook = ''
      alias cls=clear
    '';
    LLVM_BIN = pkgs.clang + "/bin";
    buildInputs = with pkgs; [
      scala-cli

      # for scala-native
      stdenv
      sbt
      openjdk
      boehmgc
      libunwind
      clang
      zlib

      # for sttp
      libidn2
      curl
    ];
    LD_LIBRARY_PATH = "${pkgs.libidn2.out}/lib:${pkgs.curl.out}/lib";
  };
} 
