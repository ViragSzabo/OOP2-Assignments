# Hospital Management System

## Overview
The Hospital Management System is a Java application designed to manage ICU operations in a hospital. It handles patient admissions, bed assignments, medical device management, and FTE (Full-Time Equivalent) calculations. The system is equipped with unit tests using JUnit to ensure functionality.

## Project Structure
### Packages
- **`Week1.Hospital.Implementation.Building`**: Manages physical aspects of the hospital.
    - `Bed.java`: Represents a hospital bed with methods to assign and vacate beds.
    - `Patient.java`: Represents a patient with attributes such as name, date of birth, gender, and medical details.
    - `BloodPressure.java`: Represents a patient's blood pressure.

- **`Week1.Hospital.Implementation.Device`**: Manages medical devices used in the ICU.
    - `MedicalDevice.java`: Abstract class for medical devices with an abstract method `monitorStatus()`.
    - `HeartMonitor.java`: Monitors heart rate.
    - `BloodPressureMonitor.java`: Monitors blood pressure.

- **`Week1.Hospital.Implementation.System`**: Contains system management and utility classes.
    - `ICU.java`: Manages ICU operations, including bed assignments and FTE calculations.
    - `FTECalculator.java`: Utility class for calculating FTE based on devices and patients.
    - `CodeBlackException.java`: Custom exception for error handling in the ICU.
    - `Status.java`: Enum for status levels (NORMAL, WARNING, CRITICAL).

### Testing
- **`Week1.Hospital.Implementation.Building`**:
    - `BedTest.java`: Tests for the `Bed` class.
    - `PatientTest.java`: Tests for the `Patient` class.
    - `BloodPressureTest.java`: Tests for the `BloodPressure` class.

- **`Week1.Hospital.Implementation.Device`**:
    - `MedicalDeviceTest.java`: Base test class (abstract).
    - `HeartMonitorTest.java`: Tests for the `HeartMonitor` class.
    - `BloodPressureMonitorTest.java`: Tests for the `BloodPressureMonitor` class.

- **`Week1.Hospital.Implementation.System`**:
    - `ICUTest.java`: Tests for the `ICU` class.
    - `FTECalculatorTest.java`: Tests for the `FTECalculator` class.
    - `CodeBlackExceptionTest.java`: Tests for the `CodeBlackException` class.
    - `StatusTest.java`: Tests for the `Status` enum.

## Setup
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/hospital-management-system.git
   cd hospital-management-system
2. **Build the Project**:
    - With Maven: mvn clean install
    - With Gradle: gradle build
3. **Run Tests**:
    - With Maven: mvn test
    - With Gradle: gradle test

## Usage
**Creating an ICU**: 
Instantiate an ICU object and add beds and medical devices. 
You can then admit patients and check the status of beds and devices.
**Testing**: 
Use JUnit to verify the functionality of each component. 
Ensure all tests pass after making changes.

## Contact
**Student**: Virag Szabo
**Student number**: 4727444
**School**: NHL Stenden