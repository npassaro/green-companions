module Validators
  class MonthsArrayValidator < ActiveModel::EachValidator
    MONTHS = 1..12

    def validate_each(record, attribute, value)
      unless is_valid?(value)
        record.errors.add attribute, "must be array of months with values between #{MONTHS.begin} and #{MONTHS.end}"
      end
    end


    private
      def is_valid?(value)
        is_array?(value) && (value.empty? || is_valid_month?(value))
      end

      def is_valid_month?(value)
        value.any? { |m| MONTHS.include? m }
      end

      def is_array?(value)
        value.kind_of?(Array)
      end
  end
end
