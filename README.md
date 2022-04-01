## Create the CelestialBody Class

### Fields

| Planet | mass | diameter | distance from Sun | hue |
| --- | --- | --- | --- | --- |
| Sun | 100 | 50 | 0 | 38 |
| Earth | 1 | 20 | 150 | 160 |
| Mercury | 0.6 | 10 | 100 | 20 |

We need our `Planet` class to contain the data listed in the above table.

Each `Planet` will also need `Vector`s for their physics.
    - `position` containing their `x` and `y` coordinate
    - `velocity` how fast (magnitude) and in what direction (normalized)
    - `acceleration` force affects how a body accelerates. This can be initialized
    to `(0, 0)` and will be re-calculated each frame.

Finally, each `Planet` will have a reference to one special "Planet", the Sun.
Add a field to reference the Planet which we will be using as our Sun.

Create constructors, getters, and setters.

### Methods

`Vector calcForces()` returns a Vector pointing towards the Sun with a magnitude
equal to the force of gravity felt between the objects. (See the 'Calculations'
 section for help with this method). **This function returns a zero Vector if the
 `sun` field is null**.

`void move()` acceleration is force/mass. Force can be obtained via `calcForces()`.
    - velocity is increased by acceleration.
    - position is increased by velocity.

`void drawSelf()` uses the static `p` applet reference to draw an ellipse
with the Planet's `hue` at the Planet's `position` with size `diameter`.

## Running the Simulation

In the Main class create a Sun and a Planet.
The Sun has zero initial velocity and its `sun` field should be set to `null`.
The Earth should have a perpendicular initial velocity.

### A Completed Project Will:

Have two or three planets orbiting a Sun. The orbits do not have to be perfect but
should remain steady for several cycles.


## Extension

One conspicuos, missing thing in this simulation is having the planets attract each other.
To do this well requires using arrays and loops to iterate through all of the planets and apply Newton's formula between all of them. The numbers in this simulation have been selected for simplicity and with the assumption that planets are only attracted to the Sun.

Can you make planets attracted to each other as well as the Sun *and* maintain stability in the simulation?
If you get this working you could also implement other objects such as asteroids and moons.

## Calculations

### Initial Velocity

All `Planets` are pulled directly towards the Sun (ignoring any forces the Planets
may impart on each other). In order for Planets to orbit the sun rather than be
pulled directly into it, they must be given some initial velocity perpendicular
to the Sun.

[image]

When initializing your planets, make sure their velocity is not set to zero.
You may have to try a few values before finding a stable orbit.

### Newton's Law of Gravitation

The force of gravity between two bodies can be found using this equation published
by Isaac Newton in 1687:

### F<sub>g</sub> = G * m<sub>1</sub>m<sub>2</sub> / r<sup>2</sup>

Where:

- `m1` and `m2` are the masses of the two bodies.
- `r` is the distance between them.
- `G` is the gravitational constant.

Our `calcForces` method needs to find a value for each of these. It will also need
a direction vector pointing towards the sun.

#### Finding the Direction:

The Sun and the Planet both have their positions defined by a Vector as shown below:

[image]

There is some Vector **R** which, if added to **P**, would equal **S** as indicated
by the dotted blue line.

P + R = S

[image]

We can subtract **P** from **S** to solve for **R** the distance vector between
the Planet and the Sun.

[image]

We can find the distance `r` by taking the magnitude of this Vector.
Also, by normalizing this vector we find the `directionVector`.

#### Solving for the Force:

We are not using real values, and thus it is arbitrary what value we pick for `G`.
A value of 10 seems to work well, but you may change it if you'd like to see the
effect a larger or smaller value has on the simulation.

Since we can get the mass of both the Planet and the Sun, we know `m1` and `m2`.
Plugging these values into Newton's formula will produce a scalar force value.

#### Returning the Force Vector:

Finally, we need to return the `forceVector`. This can be calculated by multiplying
the direction vector by the force scalar.

Since the directionVector has been normalized, it will have a magnitude of 1.
Therefore after the multiplication, it will have a length equal to the
force, and we can `return` it.
