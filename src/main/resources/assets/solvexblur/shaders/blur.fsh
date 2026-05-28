#version 150

uniform sampler2D CurrentFrame;
uniform sampler2D PreviousFrame;
uniform float Intensity;

in vec2 texCoord;
out vec4 fragColor;

void main() {

    vec4 current = texture(CurrentFrame, texCoord);
    vec4 previous = texture(PreviousFrame, texCoord);

    // Core motion blur blending
    vec4 result = mix(current, previous, Intensity);

    fragColor = result;
}
