#version 150

in vec2 Position;
in vec2 UV;

out vec2 texCoord;

void main() {
    texCoord = UV;
    gl_Position = vec4(Position, 0.0, 1.0);
}
