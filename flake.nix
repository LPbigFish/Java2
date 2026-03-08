{
  description = "Description for the project";

  inputs = {
    flake-parts.url = "github:hercules-ci/flake-parts";
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
  };

  outputs =
    inputs@{ flake-parts, ... }:
    flake-parts.lib.mkFlake { inherit inputs; } {
      systems = [
        "x86_64-linux"
        "aarch64-linux"
        "aarch64-darwin"
        "x86_64-darwin"
      ];
      perSystem =
        {
          config,
          self',
          inputs',
          pkgs,
          system,
          ...
        }:
        let
          java = pkgs.jdk25.override {
            enableJavaFX = true;
          };
          javafx = pkgs.openjfx25;
          maven = pkgs.maven;
          sb = pkgs.scenebuilder;
          #gradle = pkgs.gradle;
        in
        {
          devShells.default = pkgs.mkShell {
            buildInputs = [
              java
              maven
              sb

              #pkgs.glib
              #pkgs.gtk3
              #pkgs.libGL
              #pkgs.libxtst
              #pkgs.libx11
              #pkgs.libxxf86vm
            ];

            #shellHook = ''
            #  export JAVA_HOME="${pkgs.openjdk25}/lib/openjdk"
            #  export PATH="$JAVA_HOME/bin:$PATH"
            #  export LD_LIBRARY_PATH="${
            #    pkgs.lib.makeLibraryPath [
            #      pkgs.glib
            #      pkgs.gtk3
            #      pkgs.libGL
            #      pkgs.libxtst
            #    ]
            #  }:$LD_LIBRARY_PATH"
            #  export JAVAFX_PATH="${pkgs.openjfx25}/lib"
            #'';
          };
        };
    };
}
