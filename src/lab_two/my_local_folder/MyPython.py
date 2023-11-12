def calculate_area(length, width):
    """Calculate the area of a rectangle."""
    area = length * width
    return area

def print_greeting(name):
    """Print a personalized greeting."""
    print(f"Hello, {name}! Welcome to the Python functions example.")

# Example usage of functions
length = float(input("Enter the length of the rectangle: "))
width = float(input("Enter the width of the rectangle: "))

area_result = calculate_area(length, width)
print(f"The area of the rectangle is: {area_result}")

name = input("Enter your name: ")
print_greeting(name)


